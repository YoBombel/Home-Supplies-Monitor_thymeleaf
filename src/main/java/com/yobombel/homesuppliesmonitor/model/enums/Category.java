package com.yobombel.homesuppliesmonitor.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    FOOD("Food"),
    CLEANING("Cleaning"),
    OTHER("Other");

    private final String value;

}