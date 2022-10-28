package com.yobombel.homesuppliesmonitor.Service;

import com.yobombel.homesuppliesmonitor.Model.Item;
import com.yobombel.homesuppliesmonitor.Repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public void saveItemList(List<Item> itemList){
        itemRepository.saveAll(itemList);
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

}