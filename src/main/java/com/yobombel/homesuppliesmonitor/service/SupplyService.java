package com.yobombel.homesuppliesmonitor.service;

import com.yobombel.homesuppliesmonitor.config.LimitConfig;
import com.yobombel.homesuppliesmonitor.exception.ItemLimitException;
import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import com.yobombel.homesuppliesmonitor.repository.SupplyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public List<Supply> findAll() {
        return supplyRepository.findAll
                (Sort.by(Sort.Order.asc("category"))
                        .and(Sort.by(Sort.Order.asc("name"))));
    }

    public List<Supply> findByCategory(String category) {
        return supplyRepository.findByCategoryOrderByNameDesc(Category.valueOf(category.toUpperCase()));
    }

    public void saveItem(Supply supply) {
        if(supplyRepository.count() >= (long) LimitConfig.ITEM_LIMIT) throw new ItemLimitException();
        supplyRepository.save(supply);
    }

    public void updateAmount(String name, Amount amount) {
        supplyRepository.findById(name)
                .map(item -> {
                    item.setAmount(amount);
                    return supplyRepository.save(item);
                });
    }

    public Optional<Supply> findByName(String name) {
        return supplyRepository.findByNameIgnoreCaseOrderByNameAsc(name);
    }

    public void deleteByName(String name) {
        supplyRepository.deleteItemByNameIgnoreCase(name);
    }

    public List<Supply> getLowSupplies(){
        return new java.util.ArrayList<>(findAll()
                .stream()
                .filter(i -> i.getAmount().compareTo(Amount.LOW) <= 0)
                .sorted()
                .toList());
    }

}