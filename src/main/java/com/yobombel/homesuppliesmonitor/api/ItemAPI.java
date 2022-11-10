package com.yobombel.homesuppliesmonitor.api;

import com.yobombel.homesuppliesmonitor.model.Item;
import com.yobombel.homesuppliesmonitor.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemAPI {

    private final ItemService itemService;

    @GetMapping("")
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @GetMapping("{name}")
    public Optional<Item> getItemByName(@PathVariable String name) {
        return itemService.findByName(name);
    }

    @PostMapping("")
    public void addItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @GetMapping("/category/{category}")
    public List<Item> getCategory(@PathVariable String category) {
        return itemService.findByCategory(category);
    }
}
