package com.yobombel.homesuppliesmonitor.controller;

import com.yobombel.homesuppliesmonitor.model.ShoppingItem;
import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.repository.ShoppingItemRepository;
import com.yobombel.homesuppliesmonitor.service.SupplyService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("shopping_list")
public class ShoppingListController {

    private final ShoppingItemRepository shoppingItemRepository;
    private final SupplyService supplyService;
    private static final Logger log = LogManager.getLogger(ShoppingListController.class);

    @Autowired
    public ShoppingListController(ShoppingItemRepository shoppingItemRepository, SupplyService supplyService) {
        this.shoppingItemRepository = shoppingItemRepository;
        this.supplyService = supplyService;
    }

    @ModelAttribute(name = "shoppingItem")
    public ShoppingItem newShoppingItem(){ return new ShoppingItem();}

    @ModelAttribute(name = "shoppingList")
    public List<ShoppingItem> addShoppingListToModel() {return shoppingItemRepository.findAll();}

    @ModelAttribute(name = "supplyList")
    public List<Supply> addLowSupplyListToModel() {return supplyService.getLowSupplies();}

    @GetMapping("")
    public String showShoppingList(Model model){
        log.info("Received request for shopping list.");
        return "shopping_list";
    }

    @PostMapping("")
    public String addItem(@Valid ShoppingItem shoppingItem, BindingResult bindingResult, Model model) {
        log.info("User tries to add new item.");
        if (bindingResult.hasErrors()) {
            log.info("Item add failed - incorrectly filled form.");
            return "shopping_list";
        }
        shoppingItemRepository.save(shoppingItem);
        log.info("User added new item: " + shoppingItem);
        return "redirect:/shopping_list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String name) {
        shoppingItemRepository.deleteItemByNameIgnoreCase(name);
        log.info("User deleted shopping item " + name);
        return "redirect:/shopping_list";
    }


}