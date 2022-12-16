package com.yobombel.homesuppliesmonitor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shopping_item")
public class ShoppingItem implements Comparable<ShoppingItem> {

    @Id
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category")
    private String notes;

    @Override
    public int compareTo(ShoppingItem shoppingItem) {
        return this.getName().compareTo(shoppingItem.getName());
    }
}
