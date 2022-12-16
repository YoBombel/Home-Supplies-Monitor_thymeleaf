package com.yobombel.homesuppliesmonitor.repository;

import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, String> {

    Optional<Supply> findByNameIgnoreCaseOrderByNameAsc(String name);
    List<Supply> findByCategoryOrderByNameDesc(Category category);
    @Transactional
    void deleteItemByNameIgnoreCase(String name);

}