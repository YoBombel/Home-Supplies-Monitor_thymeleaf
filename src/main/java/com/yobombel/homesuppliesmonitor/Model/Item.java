package com.yobombel.homesuppliesmonitor.Model;

import com.yobombel.homesuppliesmonitor.Model.Enums.Amount;
import com.yobombel.homesuppliesmonitor.Model.Enums.Category;
import lombok.Data;

@Data
public class Item {

    private String name;
    private Category category;
    private Amount amount;
    private boolean isFundamental;
    private boolean isPreferred;

}