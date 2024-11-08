package com.luciaricciuti.greencure.api.exception;

public class PlantNotFoundException extends RuntimeException {

    public PlantNotFoundException(Long id) {
        super("Could not find plant %s".formatted(id));
    }
}
