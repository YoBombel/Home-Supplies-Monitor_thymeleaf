package com.yobombel.homesuppliesmonitor.Model;

import com.yobombel.homesuppliesmonitor.Model.Enums.Amount;
import com.yobombel.homesuppliesmonitor.Model.Enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Item {

    @Id
    private Long id;

    private String name;
    private Category category;
    private Amount amount;
    private boolean isFundamental;
    private boolean isPreferred;

}