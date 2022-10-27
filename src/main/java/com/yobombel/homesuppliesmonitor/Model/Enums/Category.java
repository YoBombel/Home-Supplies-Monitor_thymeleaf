package com.yobombel.homesuppliesmonitor.Model.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {

    VEGGIE("Warzywa"),
    FRUIT("Owoce"),
    MEAT("Mięso"),
    CLEANING("Sprzątanie"),
    HYGIENE("Higiena");

    private String value;

}