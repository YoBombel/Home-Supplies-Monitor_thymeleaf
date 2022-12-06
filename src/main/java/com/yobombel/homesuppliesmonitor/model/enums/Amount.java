package com.yobombel.homesuppliesmonitor.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Amount {

    NONE("None"),
    LOW("Low"),
    ENOUGH("Enough"),
    MAX("Max");

    private String value;
}