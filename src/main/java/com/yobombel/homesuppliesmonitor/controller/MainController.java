package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.model.Item;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;


    @GetMapping("/")
    public String allItems(Model model) {
        model.addAttribute("allItemList", itemService.findAll());
        return "index";
    }

    @PostMapping("/")
    public String addItem(@ModelAttribute Item newItem, Model model) {
        itemService.saveItem(newItem);
        return "redirect:/";
    }

    @PostMapping("/updateAmount")
    public String changeAmount(@RequestParam String name, @RequestParam String amount, Model model) {
        itemService.updateAmount(name, Amount.valueOf(amount.toUpperCase()));
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String name) {
        itemService.deleteByName(name);
        return "redirect:/";
    }

}