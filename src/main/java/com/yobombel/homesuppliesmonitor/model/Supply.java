package com.yobombel.homesuppliesmonitor.model;

import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Supply.TABLE_NAME)
public class Supply implements Comparable<Supply>{

    public static final String TABLE_NAME = "supply";
    public static final String COLUMN_PREFIX = "s_";

    @Id
    @NonNull
    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_PREFIX + "category")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_PREFIX + "amount")
    private Amount amount;

    @Override
    public int compareTo(Supply supply) {
        return this.getName().compareTo(supply.getName());
    }
}