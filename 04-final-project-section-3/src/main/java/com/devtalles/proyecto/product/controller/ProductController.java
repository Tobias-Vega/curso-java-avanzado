package com.devtalles.proyecto.product.controller;

import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.service.ProductService;
import com.devtalles.proyecto.product.util.Validates;

import java.util.List;
import java.util.Optional;

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void addProduct(Product product) {
        Validates.validateObject(product, "El product no puede ser un dato nulo");
        productService.saveProduct(product);
    }

    public void removeProduct(Long id) {
        Validates.validateNumber(id, "El ID no puede ser nulo");
        productService.deleteProduct(id);
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public Optional<Product> getProductById(Long id) {
        Validates.validateNumber(id, "El ID no puede ser nulo");
        return productService.getProductById(id);
    }

    public void updateProduct(Product product) {
        Validates.validateObject(product, "El product no puede ser un dato nulo");
        productService.updateProduct(product);
    }
}
