package com.yobombel.homesuppliesmonitor.Service;

import com.yobombel.homesuppliesmonitor.Model.Item;
import com.yobombel.homesuppliesmonitor.Repository.ItemRepository;
import com.yobombel.homesuppliesmonitor.util.FileParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItemList(List<Item> itemList){
        itemRepository.saveAll(itemList);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

}