package com.devtalles.proyecto.record;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("TV", 200.3 );
        product.getName();
        ProductDto productDto = new ProductDto("Notebook", 100.5);
        productDto.name();
        productDto.price();
        productDto.toString();
        ProductDto.methodStatic();
    }
}
