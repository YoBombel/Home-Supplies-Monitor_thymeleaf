package com.yobombel.homesuppliesmonitor.service;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import com.yobombel.homesuppliesmonitor.config.LimitConfig;
import com.yobombel.homesuppliesmonitor.exception.ItemLimitException;
import com.yobombel.homesuppliesmonitor.model.Supply;
import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import com.yobombel.homesuppliesmonitor.repository.SupplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

@Disabled
@ExtendWith(MockitoExtension.class)
public class SupplyServiceTest {

    @Mock
    private SupplyRepository supplyRepository;

    private SupplyService supplyService;

    @BeforeEach
    public void setUp() {
        supplyService = new SupplyService(supplyRepository);
    }

    @Test
    public void testFindAll() {
        List<Supply> expectedSupplies = List.of(new Supply("test1", Category.FOOD, Amount.LOW),
                new Supply("test2", Category.CLEANING, Amount.ENOUGH));
        when(supplyRepository.findAll(Sort.by(Sort.Order.asc("category")).and(Sort.by(Sort.Order.asc("name")))))
                .thenReturn(expectedSupplies);

        List<Supply> actualSupplies = supplyService.findAll();

        assertThat(actualSupplies).isEqualTo(expectedSupplies);
        verify(supplyRepository).findAll(Sort.by(Sort.Order.asc("category")).and(Sort.by(Sort.Order.asc("name"))));
    }

    @Test
    public void testFindByCategory() {
        String category = "FOOD";
        List<Supply> expectedSupplies = List.of(new Supply("test1", Category.FOOD, Amount.LOW),
                new Supply("test2", Category.FOOD, Amount.ENOUGH));
        when(supplyRepository.findByCategoryOrderByNameDesc(Category.valueOf(category.toUpperCase())))
                .thenReturn(expectedSupplies);

        List<Supply> actualSupplies = supplyService.findByCategory(category);

        assertThat(actualSupplies).isEqualTo(expectedSupplies);
        verify(supplyRepository).findByCategoryOrderByNameDesc(Category.valueOf(category.toUpperCase()));
    }

    @Test
    public void testSaveItem() {
        Supply supply = new Supply("test", Category.OTHER, Amount.MAX);
        when(supplyRepository.count()).thenReturn((long) LimitConfig.ITEM_LIMIT - 1);
        doNothing().when(supplyRepository).save(supply);

        supplyService.saveItem(supply);

        verify(supplyRepository).count();
        verify(supplyRepository).save(supply);
    }

    @Test
    public void testSaveItem_throwsItemLimitException() {
        Supply supply = new Supply("test", Category.OTHER, Amount.MAX);
        when(supplyRepository.count()).thenReturn((long) LimitConfig.ITEM_LIMIT);

        assertThatThrownBy(() -> supplyService.saveItem(supply)).isInstanceOf(ItemLimitException.class);
        verify(supplyRepository).count();
        verify(supplyRepository, never()).save(supply);
    }

    @Test
    public void testUpdateAmount() {
        String name = "test";
        Amount amount = Amount.MAX;
        Supply expectedSupply = new Supply(name, Category.OTHER, amount);
        when(supplyRepository.findById(name)).thenReturn(Optional.of(expectedSupply));
        doNothing().when(supplyRepository).save(expectedSupply);

        supplyService.updateAmount(name, amount);

        verify(supplyRepository).findById(name);
        verify(supplyRepository).save(expectedSupply);
    }

    @Test
    public void testFindByName() {
        String name = "test";
        Supply expectedSupply = new Supply(name, Category.OTHER, Amount.MAX);
        when(supplyRepository.findByNameIgnoreCaseOrderByNameAsc(name)).thenReturn(Optional.of(expectedSupply));

        Optional<Supply> actualSupply = supplyService.findByName(name);

        assertThat(actualSupply).isEqualTo(Optional.of(expectedSupply));
        verify(supplyRepository).findByNameIgnoreCaseOrderByNameAsc(name);
    }

    @Test
    public void testDeleteByName() {
        String name = "test";
        doNothing().when(supplyRepository).deleteItemByNameIgnoreCase(name);

        supplyService.deleteByName(name);

        verify(supplyRepository).deleteItemByNameIgnoreCase(name);
    }

    @Test
    public void testGetLowSupplies() {
        List<Supply> supplies = List.of(new Supply("test1", Category.FOOD, Amount.LOW),
                new Supply("test2", Category.CLEANING, Amount.NONE),
                new Supply("test3", Category.OTHER, Amount.ENOUGH));
        when(supplyRepository.findAll(Sort.by(Sort.Order.asc("category")).and(Sort.by(Sort.Order.asc("name")))))
                .thenReturn(supplies);

        List<Supply> lowSupplies = supplyService.getLowSupplies();

        assertThat(lowSupplies).containsExactly(new Supply("test2", Category.CLEANING, Amount.NONE),
                new Supply("test1", Category.FOOD, Amount.LOW));
        verify(supplyRepository).findAll(Sort.by(Sort.Order.asc("category")).and(Sort.by(Sort.Order.asc("name"))));
    }


}