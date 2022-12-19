package com.yobombel.homesuppliesmonitor.service;

import com.yobombel.homesuppliesmonitor.config.LimitConfig;
import com.yobombel.homesuppliesmonitor.exception.ItemLimitException;
import com.yobombel.homesuppliesmonitor.model.ShoppingItem;
import com.yobombel.homesuppliesmonitor.repository.ShoppingItemRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingItemService {

    private final ShoppingItemRepository shoppingItemRepository;
    private static final Logger log = LoggerFactory.getLogger(ShoppingItemService.class);

    public List<ShoppingItem> findAll(){
        log.info("Finding all shopping items");
        List<ShoppingItem> items = shoppingItemRepository.findAll();
        log.info("Found {} shopping items", items.size());
        return items;
    }

    public void save(ShoppingItem shoppingItem){
        log.info("Saving shopping item {}", shoppingItem);
        if(shoppingItemRepository.count() >= (long) LimitConfig.ITEM_LIMIT) {
            log.info("Cannot save shopping item, item limit reached");
            throw new ItemLimitException();
        }
        shoppingItemRepository.save(shoppingItem);
        log.info("Shopping item saved");
    }

    public void deleteByName(String name) {
        log.info("Deleting shopping item with name {}", name);
        shoppingItemRepository.deleteItemByNameIgnoreCase(name);
        log.info("Shopping item deleted");
    }
}