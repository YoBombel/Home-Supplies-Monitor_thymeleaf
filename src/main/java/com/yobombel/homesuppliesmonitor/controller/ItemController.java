package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/allitems")
    public String allItems(Model model){
        model.addAttribute("allItemList", itemService.findAll());
        return "allItems";
    }

}
