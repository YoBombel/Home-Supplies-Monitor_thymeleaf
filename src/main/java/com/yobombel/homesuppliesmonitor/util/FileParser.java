package com.yobombel.homesuppliesmonitor.util;

import com.yobombel.homesuppliesmonitor.Model.Enums.Amount;
import com.yobombel.homesuppliesmonitor.Model.Enums.Category;
import com.yobombel.homesuppliesmonitor.Model.Item;
import com.yobombel.homesuppliesmonitor.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class FileParser {

    private final ItemService itemService;

    public List<Item> parseItemListFromFile(File file) throws FileNotFoundException {

        Pattern pattern = Pattern.compile(",");
        Scanner scanner = new Scanner(file);

        String fileToCategory = file.getName().toUpperCase(Locale.ROOT);
        Category category = Category.valueOf(fileToCategory);

        List<Item> itemList = new ArrayList<>();

        while (scanner.useDelimiter(pattern).hasNext()) {
            Item item = new Item();
            item.setName(scanner.next().trim());
            item.setAmount(Amount.NONE);
            item.setCategory(category);
            item.setFundamental(false);
            item.setPreferred(false);
            itemList.add(item);
        }
        return itemList;
    }


    @PostConstruct
    public void fillDB() throws FileNotFoundException {

        List<File> fileList = listPathsToFiles();

        for (File file : fileList
        ) {
            itemService.saveItemList(
                    parseItemListFromFile(file));
        }
    }

    private List<File> listPathsToFiles() {

        List<File> fileList = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get("src/main/resources/items/"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(p -> fileList.add(new File(p.toUri())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileList;
    }

}