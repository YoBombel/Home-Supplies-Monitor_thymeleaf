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
@Table(name = "supply")
public class Supply implements Comparable<Supply>{

    @Id
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(name = "amount")
    private Amount amount;

    @Override
    public int compareTo(Supply supply) {
        return this.getName().compareTo(supply.getName());
    }
}