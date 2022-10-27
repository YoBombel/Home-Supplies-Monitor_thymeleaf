package com.yobombel.homesuppliesmonitor.Controller;

import com.yobombel.homesuppliesmonitor.Model.Item;
import com.yobombel.homesuppliesmonitor.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ItemAPI {

    private final ItemService itemService;

    @GetMapping("all")
    public List<Item> getAllItems(){
        return itemService.findAll();
    }

}
