package com.yobombel.homesuppliesmonitor.util;

import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class FileParser {

    private final SupplyService supplyService;

    public List<Supply> parseItemListFromFile(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);

        String fileToCategory = file.getName().toUpperCase(Locale.ROOT);
        Category category = Category.valueOf(fileToCategory);

        List<Supply> supplyList = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String name = scanner.nextLine();

            if(!name.isBlank()) {
                Supply supply = new Supply();
                supply.setName(name.trim());
                supply.setAmount(Amount.NONE);
                supply.setCategory(category);
                supplyList.add(supply);
            }
        }

        return supplyList;
    }

//    @PostConstruct
//    public void fillDB() throws FileNotFoundException {
//
//        List<File> fileList = listPathsToFiles();
//
//        for (File file : fileList
//        ) {
//            parseItemListFromFile(file)
//                    .forEach(itemService::saveItem);
//        }
//    }

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