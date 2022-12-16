package com.yobombel.homesuppliesmonitor.service;

import com.yobombel.homesuppliesmonitor.config.LimitConfig;
import com.yobombel.homesuppliesmonitor.exception.ItemLimitException;
import com.yobombel.homesuppliesmonitor.model.ShoppingItem;
import com.yobombel.homesuppliesmonitor.repository.ShoppingItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingItemService {

    private final ShoppingItemRepository shoppingItemRepository;

    public List<ShoppingItem> findAll(){
        return shoppingItemRepository.findAll();
    }

    public void save(ShoppingItem shoppingItem){
        if(shoppingItemRepository.count() >= (long) LimitConfig.ITEM_LIMIT) throw new ItemLimitException();
        shoppingItemRepository.save(shoppingItem);
    }

    public void deleteByName(String name) {
        shoppingItemRepository.deleteItemByNameIgnoreCase(name);
    }

}