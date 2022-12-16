package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.service.SupplyService;
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

    private final SupplyService supplyService;


    @GetMapping("/")
    public String allItems(Model model) {
        model.addAttribute("allItemList", supplyService.findAll());
        return "index";
    }

    @PostMapping("/")
    public String addItem(@ModelAttribute Supply newSupply, Model model) {
        supplyService.saveItem(newSupply);
        return "redirect:/";
    }

    @PostMapping("/updateAmount")
    public String changeAmount(@RequestParam String name, @RequestParam String amount, Model model) {
        supplyService.updateAmount(name, Amount.valueOf(amount.toUpperCase()));
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String name) {
        supplyService.deleteByName(name);
        return "redirect:/";
    }

    @GetMapping("/shopping_list")
    public String shoppingList(Model model){
        model.addAttribute("shoppingList", supplyService.getLowSupplies());
        return "shopping_list";
    }

}