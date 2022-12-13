package com.yobombel.homesuppliesmonitor.service;

import com.yobombel.homesuppliesmonitor.config.LimitConfig;
import com.yobombel.homesuppliesmonitor.exception.ItemLimitException;
import com.yobombel.homesuppliesmonitor.model.Item;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import com.yobombel.homesuppliesmonitor.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll
                (Sort.by(Sort.Order.asc("category"))
                        .and(Sort.by(Sort.Order.asc("name"))));
    }

    public List<Item> findByCategory(String category) {
        return itemRepository.findByCategoryOrderByNameDesc(Category.valueOf(category.toUpperCase()));
    }

    public void saveItem(Item item) {
        if(itemRepository.count() >= (long) LimitConfig.ITEM_LIMIT) throw new ItemLimitException();
        itemRepository.save(item);
    }

    public void updateAmount(String name, Amount amount) {
        itemRepository.findById(name)
                .map(item -> {
                    item.setAmount(amount);
                    return itemRepository.save(item);
                });
    }

    public Optional<Item> findByName(String name) {
        return itemRepository.findByNameIgnoreCaseOrderByNameAsc(name);
    }

    public void deleteByName(String name) {
        itemRepository.deleteItemByNameIgnoreCase(name);
    }

    public List<Item> getLowSupplies(){
        return new java.util.ArrayList<>(findAll()
                .stream()
                .filter(i -> i.getAmount().compareTo(Amount.LOW) <= 0)
                .sorted()
                .toList());
    }

}