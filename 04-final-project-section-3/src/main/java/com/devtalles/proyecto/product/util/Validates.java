package com.devtalles.proyecto.product.util;

import com.devtalles.proyecto.product.exceptions.InvalidProductException;

public class Validates {

    private Validates() {
        throw new UnsupportedOperationException("Clase utilitaria");
    }

    public static <T extends Number> void validateNumber(T value, String message) {
        if (value == null) {
            throw new InvalidProductException(message);
        }
    }

    public static <T> void validateObject(T obj, String message) {
        if (obj == null) {
            throw new InvalidProductException(message);
        }
    }

    public static void validateText(String txt, String message) {
        if (txt == null || txt.isBlank()) {
            throw new InvalidProductException(message);
        }
    }
}
