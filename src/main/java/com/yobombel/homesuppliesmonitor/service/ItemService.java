package com.yobombel.homesuppliesmonitor.service;

import com.yobombel.homesuppliesmonitor.model.Item;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import com.yobombel.homesuppliesmonitor.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll
                (Sort.by(Sort.Order.asc("category"))
                        .and(Sort.by(Sort.Order.asc("name"))));
    }

    public List<Item> findByCategory(String category){
        return itemRepository.findByCategory(Category.valueOf(category.toUpperCase()));
    }

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public Optional<Item> findByName(String name){
        return itemRepository.findByNameIgnoreCase(name);
    }

    public void deleteByName(String name){
        itemRepository.deleteItemByNameIgnoreCase(name);
    }



}