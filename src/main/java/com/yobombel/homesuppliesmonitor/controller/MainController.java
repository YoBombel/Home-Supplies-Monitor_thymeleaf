package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.service.SupplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final SupplyService supplyService;
    private static final Logger log = LogManager.getLogger(MainController.class);

    @ModelAttribute(name = "supply")
    public Supply newSupply(){ return new Supply();}

    @GetMapping("/")
    public String allItems(Model model) {
        model.addAttribute("allItemList", supplyService.findAll());
        log.debug("Received request for main page.");
        return "index";
    }

    @PostMapping("/")
    public String addItem(@Valid Supply supply, BindingResult bindingResult, Model model) {
        log.info("User tries to add new item.");
        if (bindingResult.hasErrors()) {
            log.info("Item add failed - incorrectly filled form.");
            log.debug(bindingResult.getFieldError("name"));
            model.addAttribute("allItemList", supplyService.findAll());
            return "index";
        }
        supplyService.saveItem(supply);
        log.info("User added new item: " + supply);
        return "redirect:/";
    }

    @PostMapping("/updateAmount")
    public String changeAmount(@RequestParam String name, @RequestParam String amount, Model model) {
        supplyService.updateAmount(name, Amount.valueOf(amount.toUpperCase()));
        log.info("User updated amount of " + name + " to: " + amount);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String name) {
        supplyService.deleteByName(name);
        log.info("User deleted item " + name);
        return "redirect:/";
    }

}