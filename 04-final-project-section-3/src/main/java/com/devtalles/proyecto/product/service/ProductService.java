package com.devtalles.proyecto.product.service;

import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.interfaces.ProductRepository;
import com.devtalles.proyecto.product.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) {
        ProductValidator.validate(product);
        if (productRepository.existById(product.getId())) {
            throw new InvalidProductException("El producto que desea agregar ya existe");
        }

        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existById(id)) {
            throw new ProductNotFoundException("El producto que desea eliminar no existe");
        }

        productRepository.delete(id);
    }

    public void updateProduct(Product product) {
        ProductValidator.validate(product);

        if (!productRepository.existById(product.getId())) {
            throw new ProductNotFoundException("El producto que desea actualizar no existe");
        }

        productRepository.update(product);
    }
}
