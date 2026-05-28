package com.devtalles.proyecto.product.view;

import com.devtalles.proyecto.product.controller.ProductController;
import com.devtalles.proyecto.product.exceptions.InvalidProductException;
import com.devtalles.proyecto.product.exceptions.ProductNotFoundException;
import com.devtalles.proyecto.product.model.Product;
import com.devtalles.proyecto.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductView {
    private final ProductController productController;
    private final Scanner scanner;

    public ProductView(ProductController productController) {
        this.productController = productController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("4. Eliminar Producto por ID");
            System.out.println("4. Modificar Producto por ID");
            System.out.println("6. Salir");
            System.out.println("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addProductView();
                case 2 -> showAllProductsView();
                case 3 -> findByIdProductView();
                case 4 -> deleteProductView();
                case 6 -> {
                    System.out.println("Programa finalizado");
                    scanner.close();
                    return;
                }
            }
        }
    }

    private void addProductView() {
        long id = readValidLong("Ingrese el ID del producto", 0);
        String name = readNonEmptyString("Ingrese el nombre del producto");
        double price = readValidDouble("Ingrese el precio del producto", 10);
        int stock = readValidInteger("Ingrese el stock del producto", 1);
        String categoryString = readNonEmptyString("Ingrese la categoría del producto: \nELECTRÓNICOS, COMIDAS, LIBROS, OTROS");
        ProductCategory category = ProductCategory.valueOf(categoryString);

        Product product = new Product(id,name, price, stock, category);
        try {
            productController.addProduct(product);
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showAllProductsView() {
        List<Product> products = productController.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("Lista de productos vacía");
        }

        products.forEach(this::showProductView);
    }

    private void findByIdProductView() {
        long id = readValidLong("Ingrese el ID del producto", 0);
        try {
            Optional<Product> product = productController.getProductById(id);
            if (product.isEmpty()) {
                System.out.println("El producto no se encuentra en la base de datos");
                return;
            }

            Product product1 = product.get();
            showProductView(product1);
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteProductView() {
        long id = readValidLong("Ingrese el ID del producto", 0);
        try {
            productController.removeProduct(id);
        } catch (ProductNotFoundException | InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showProductView(Product product) {
        System.out.println("\n Producto:");
        System.out.println("Id: " + product.getId());
        System.out.println("Nombre: " + product.getName());
        System.out.println("Precio: " + product.getPrice());
        System.out.println("Stock: " + product.getStock());
        System.out.println("Categoría: " + product.getCategory());
        System.out.println("----------------------------------");
    }

    private String readNonEmptyString(String message) {
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine().trim();
            if (input.length() < 3) {
                System.out.println("El valor no puede ser vacío o el nombre es muy corto");
            }
        } while (input.length() < 3);

        return input;
    }

    private long readValidLong(String message, long min) {
        long value;

        do {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try {
                value = Long.parseLong(input);

            if (value < min) {
                System.out.println("El valor debe ser al menos " + min);
                continue;
            }

            return value;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private int readValidInteger(String message, long min) {
        int value;

        do {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try {
                value = Integer.parseInt(input);

            if (value < min) {
                System.out.println("El valor debe ser al menos " + min);
                continue;
            }

            return value;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private double readValidDouble(String message, long min) {
        double value;

        do {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try {
                value = Double.parseDouble(input);

            if (value < min) {
                System.out.println("El valor debe ser al menos " + min);
                continue;
            }

            return value;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
