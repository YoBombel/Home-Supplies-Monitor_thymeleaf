package com.yobombel.homesuppliesmonitor.exception;

import com.yobombel.homesuppliesmonitor.config.LimitConfig;

public class ItemLimitException extends RuntimeException{

    public ItemLimitException(){
        super("Item limit reached: " + LimitConfig.ITEM_LIMIT + " items.");
    }

}
