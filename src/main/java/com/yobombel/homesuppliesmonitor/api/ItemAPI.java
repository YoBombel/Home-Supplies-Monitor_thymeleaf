package com.yobombel.homesuppliesmonitor.api;

import com.yobombel.homesuppliesmonitor.model.Item;
import com.yobombel.homesuppliesmonitor.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemAPI {

    private final ItemService itemService;

    @GetMapping("all")
    public List<Item> getAllItems(){
        return itemService.findAll();
    }

}
