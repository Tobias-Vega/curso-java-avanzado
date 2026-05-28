package com.devtalles.proyecto.product.interfaces;

import com.devtalles.proyecto.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save(Product product);
    void delete(Long id);
    void update(Optional<Product> product);
    boolean existById(Long id);
}
