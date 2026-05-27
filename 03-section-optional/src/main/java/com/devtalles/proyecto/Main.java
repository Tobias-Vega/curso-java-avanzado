package com.devtalles.proyecto;


import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<String> name = Optional.of("Tobías");

        if (name.isPresent()) {
            System.out.println("El nombre está presente");
        }

        String value = null;
        Optional<String> nick = Optional.ofNullable(value);
        Optional<String> empty = Optional.empty();

        if (nick.isPresent()) {
            System.out.println("El nick está presente");
        } else {
            System.out.println("Nulo");
        }

        if (empty.isEmpty()) {
            System.out.println("El valor está presente");
        } else {
            System.out.println("Vacío");
        }

        Optional<String> greeding = Optional.of("Hola mundo");

        greeding.ifPresent(message -> System.out.println("Soy Tobías: " + message));
    }
}
