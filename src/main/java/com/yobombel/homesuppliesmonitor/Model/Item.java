package com.yobombel.homesuppliesmonitor.Model;

import com.yobombel.homesuppliesmonitor.Model.Enums.Amount;
import com.yobombel.homesuppliesmonitor.Model.Enums.Category;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;

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