package com.luciaricciuti.greencure.api.controller;

import com.luciaricciuti.greencure.api.exception.PlantNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlantControllerAdvice {

    @ExceptionHandler(PlantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePlantNotFound(PlantNotFoundException e) {
        return e.getMessage();
    }
}
