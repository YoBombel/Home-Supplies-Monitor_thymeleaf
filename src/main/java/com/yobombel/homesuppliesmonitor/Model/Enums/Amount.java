package com.yobombel.homesuppliesmonitor.Model.Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Amount {

    ENOUGH("Dość"),
    MED("Średnio"),
    LOW("Mało"),
    NONE("Zero");

    private String value;
}