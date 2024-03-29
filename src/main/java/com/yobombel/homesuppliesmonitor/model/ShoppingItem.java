package com.yobombel.homesuppliesmonitor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ShoppingItem.TABLE_NAME)
public class ShoppingItem implements Comparable<ShoppingItem> {

    public static final String TABLE_NAME = "shopping_item";
    public static final String COLUMN_PREFIX = "si_";

    @Id
    @Size(min = 1, max = 20, message = "Name must be 1-20 characters long.")
    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @Column(name = COLUMN_PREFIX + "notes")
    private String notes;

    @Override
    public int compareTo(ShoppingItem shoppingItem) {
        return this.getName().compareTo(shoppingItem.getName());
    }
}
