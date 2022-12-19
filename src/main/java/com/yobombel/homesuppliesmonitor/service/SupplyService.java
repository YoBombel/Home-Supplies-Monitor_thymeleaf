package com.yobombel.homesuppliesmonitor.service;

import com.yobombel.homesuppliesmonitor.config.LimitConfig;
import com.yobombel.homesuppliesmonitor.exception.ItemLimitException;
import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import com.yobombel.homesuppliesmonitor.repository.SupplyRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private static final Logger log = LoggerFactory.getLogger(SupplyService.class);

    public List<Supply> findAll() {
        log.info("Finding all supplies");
        List<Supply> supplies = supplyRepository.findAll(Sort.by(Sort.Order.asc("category"))
                .and(Sort.by(Sort.Order.asc("name"))));
        log.info("Found {} supplies", supplies.size());
        return supplies;
    }

    public List<Supply> findByCategory(String category) {
        log.info("Finding supplies with category {}", category);
        List<Supply> supplies = supplyRepository.findByCategoryOrderByNameDesc(Category.valueOf(category.toUpperCase()));
        log.info("Found {} supplies", supplies.size());
        return supplies;
    }

    public void saveItem(Supply supply) {
        log.info("Saving supply {}", supply);
        if (supplyRepository.count() >= (long) LimitConfig.ITEM_LIMIT) {
            log.info("Cannot save supply, item limit reached");
            throw new ItemLimitException();
        }
        supplyRepository.save(supply);
        log.info("Supply saved");
    }

    public void updateAmount(String name, Amount amount) {
        log.info("Updating amount of supply {} to {}", name, amount);
        supplyRepository.findById(name)
                .map(item -> {
                    item.setAmount(amount);
                    return supplyRepository.save(item);
                });
        log.info("Amount updated");
    }

    public Optional<Supply> findByName(String name) {
        log.info("Finding supply with name {}", name);
        Optional<Supply> supply = supplyRepository.findByNameIgnoreCaseOrderByNameAsc(name);
        log.info("Supply found: {}", supply.isPresent());
        return supply;
    }

    public void deleteByName(String name) {
        log.info("Deleting supply with name {}", name + " from category: " + supplyRepository.findById(name).get().getCategory().getValue());
        supplyRepository.deleteItemByNameIgnoreCase(name);
        log.info("Supply deleted");
    }

    public List<Supply> getLowSupplies() {
        log.info("Finding low supplies");
        List<Supply> lowSupplies = new java.util.ArrayList<>(findAll()
                .stream()
                .filter(i -> i.getAmount().compareTo(Amount.LOW) <= 0)
                .sorted()
                .toList());
        log.info("Found {} low supplies", lowSupplies.size());
        return lowSupplies;
    }

}