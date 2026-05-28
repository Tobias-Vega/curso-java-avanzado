package com.devtalles.proyecto.example03;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // map
        Optional<String> name = Optional.of("   ToBíaS   ");
        String nameUpperCase = name
                .map(String::toLowerCase)
                .map(String::trim)
                .orElse("Sin nombre");

        System.out.println("Username " + nameUpperCase);

        // flatmap
        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.of("Valor interno"));

        Optional<String> resultMap = optionalOfOptional.flatMap(op -> op);

        System.out.println(resultMap);
    }

}
