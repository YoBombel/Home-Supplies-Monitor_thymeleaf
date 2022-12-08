package com.yobombel.homesuppliesmonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemLimitExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ItemLimitException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String ItemLimitHandler(ItemLimitException exception){
        return exception.getMessage();
    }

}
