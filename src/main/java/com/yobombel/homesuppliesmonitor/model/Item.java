package com.yobombel.homesuppliesmonitor.model;

import com.yobombel.homesuppliesmonitor.model.enums.Amount;
import com.yobombel.homesuppliesmonitor.model.enums.Category;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;

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

    @Column(name = "fundamental")
    private boolean isFundamental;

    @Column(name = "preferred")
    private boolean isPreferred;

}