package com.devtalles.proyecto.product.repository;

import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryServices implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public boolean existById(Long id) {
        return products.stream()
                .anyMatch(product -> product.getId().equals(id));
    }

    @Override
    public void update(Optional<Product> product) {

    }

    @Override
    public void delete(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
