package com.devtalles.proyecto.record;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /* Product product = new Product("TV", 200.3 );
        product.getName();
        ProductDto productDto = new ProductDto("Notebook", 100.5);
        productDto.name();
        productDto.price();
        productDto.toString();
        ProductDto.methodStatic(); */

        List<ProductDto> products = List.of(
                new ProductDto("Notebook", 1200.0),
                new ProductDto("Mouse", 25.5),
                new ProductDto("Keyboard", 55.0),
                new ProductDto("Keyboard", 89.0)
        );

        List<String> discountProducts = products.stream()
                .map(productDto -> new ProductDto(productDto.name(), productDto.price() * 0.90))
                .map(productDto -> String.format("%s: $%.2f", productDto.name(), productDto.price()))
                .toList();

        System.out.println(discountProducts);

        Map<String, List<ProductDto>> byPriceRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price() > 50.0 ? "Caro" : "Barato"
                ));

        Map<String, Long> countByRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price() > 50.0 ? "Caro" : "Barato",
                        Collectors.counting()
                ));

//        System.out.println(byPriceRange);
//        System.out.println(countByRange);

        // 2. Reducción matemática
        Double total = products.stream()
                .map(ProductDto::price)
                .reduce(0.0, Double::sum);

        System.out.println(total);

        String productsummary = products.stream()
                .map(productDto -> productDto.name() + " ($" + productDto.price() + ")")
                .reduce("", (s1, s2) -> {
                    if (s1.isEmpty()) {
                        return s2;
                    } else {
                        return s1 + " | " + s2;
                    }
        });

        System.out.println(productsummary);

        // Conversión entre colecciones
        Set<Double> uniquePrices = products.stream()
                .map(ProductDto::price)
                .collect(Collectors.toSet());

        System.out.println(uniquePrices);

        Map<String, Double> productMap = products.stream()
                .collect(Collectors.toMap(
                        ProductDto::name,
                        ProductDto::price,
                        (oldValue, newValue) -> newValue
                ));

        System.out.println(productMap);

        List<ProductDto> expensiveProducts = productMap.entrySet().stream()
                        .filter(e -> e.getValue() > 50.00)
                        .map(e -> new ProductDto(e.getKey(), e.getValue()))
                        .toList();

        System.out.println(expensiveProducts);

    }
}
