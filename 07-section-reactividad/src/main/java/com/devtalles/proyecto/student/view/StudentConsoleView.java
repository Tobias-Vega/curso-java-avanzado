package com.devtalles.proyecto.student.view;

import com.devtalles.proyecto.student.controller.StudentController;

import java.util.Scanner;

public class StudentConsoleView {
    private final StudentController controller;
    private final Scanner scanner;


    public StudentConsoleView(StudentController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
       while (true) {
           System.out.println("Si desea salir de la aplicación, ingrese 'exit'");

           System.out.println("Ingrese el nombre");
           String name = scanner.nextLine().trim();

           if (name.equalsIgnoreCase("exit")) break;

           System.out.println("Ingrese la edad");
           String age = scanner.nextLine().trim();

           boolean ok = controller.processInput(name, age);

           if (!ok) {
               System.out.println("Edad inválida...");
           }

           controller.finishInput();
           System.out.println("Fin...");
       }
    }



}
