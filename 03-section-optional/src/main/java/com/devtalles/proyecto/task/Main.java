package com.devtalles.proyecto.task;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // filter

        Optional<String> dni = Optional.of("1234567");

        Optional<String> result = dni.filter(d -> d.startsWith("1"));

        System.out.println("DNI: " + result.orElse("No válido"));

        Optional<String> email = Optional.ofNullable("  tobias@gmail.com  ");

        email
                .map(String::trim)
                .filter(e -> e.contains("@"))
                .filter(e -> e.contains(".com"))
                .ifPresent(message -> System.out.println("Enviando correo a: " + message));
    }
}
