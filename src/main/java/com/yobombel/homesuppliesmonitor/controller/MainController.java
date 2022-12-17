package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger LOGGER = LogManager.getLogger(MainController.class);

    @GetMapping("/")
    public String allItems(Model model) {
        model.addAttribute("allItemList", supplyService.findAll());
        LOGGER.info("Received request for main page.");
        return "index";
    }

    @PostMapping("/")
    public String addItem(@ModelAttribute Supply newSupply, Model model) {
        LOGGER.info("User tries to add new item.");
        supplyService.saveItem(newSupply);
        LOGGER.info("User added new item: " + newSupply);
        return "redirect:/";
    }

    @PostMapping("/updateAmount")
    public String changeAmount(@RequestParam String name, @RequestParam String amount, Model model) {
        supplyService.updateAmount(name, Amount.valueOf(amount.toUpperCase()));
        LOGGER.info("User updated amount of " + name + " to: " + amount);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String name) {
        supplyService.deleteByName(name);
        LOGGER.info("User deleted item " + name);
        return "redirect:/";
    }

    @GetMapping("/shopping_list")
    public String shoppingList(Model model) {
        LOGGER.info("Received request for shopping list.");
        model.addAttribute("shoppingList", supplyService.getLowSupplies());
        return "shopping_list";
    }

}