package com.devtalles.proyecto.example04;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // ejemplo 1
        List<String> names = List.of("Juan", "Ana", "Andrea", "Teddy", "Ricardo");

        Optional<String> first = names.stream().findFirst();

        first.ifPresent(name -> System.out.println("El primero es: " + name));

        // ejemplo 2

        List<String> emptyLsit = List.of("");

        Optional<String> firstEmpty = emptyLsit.stream().findFirst();

        System.out.println("¿Está presente? " + firstEmpty.isPresent());

        // ejemplo 3
        record Product(String name, double price){}

        List<Product> products = List.of(
                new Product("TV", 200),
                new Product("Notebook", 400)
        );

        Optional<Product> maybeTV = products.stream()
                .filter(p -> p.name().equalsIgnoreCase("tv"))
                .findFirst();

        Product result = maybeTV.orElse(new Product("Genérico", 0));

        System.out.println("Resultado: " + result.name + " - $" + result.price);
    }
}
