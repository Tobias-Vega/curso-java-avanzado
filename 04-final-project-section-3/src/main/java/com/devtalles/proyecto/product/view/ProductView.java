package com.devtalles.proyecto.product.view;

import com.devtalles.proyecto.product.controller.ProductController;

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
                case 1:

            }
        }
    }

    private void addProductView() {
        String name = readNonEmptyString("Ingrese el nombre del producto");
        String categoryString = readNonEmptyString("Ingrese la categoría del producto: \nELECTRÓNICOS, COMIDAS, LIBROS, OTROS");
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

    
}
