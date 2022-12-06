package com.yobombel.homesuppliesmonitor.repository;

import com.yobombel.homesuppliesmonitor.model.Item;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Optional<Item> findByNameIgnoreCaseOrderByNameAsc(String name);
    List<Item> findByCategoryOrderByNameDesc(Category category);
    @Transactional
    void deleteItemByNameIgnoreCase(String name);

}