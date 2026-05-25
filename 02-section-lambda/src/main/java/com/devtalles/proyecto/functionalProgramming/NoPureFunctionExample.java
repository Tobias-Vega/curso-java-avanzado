package com.devtalles.proyecto.functionalProgramming;

public class NoPureFunctionExample {

    static int counter = 0; // estado compartido (efecto colateral)

    public static int incrementCounter(int value) {
        counter += value; // modifica estado global
        return counter;
    }

    static void main(String[] args) {
        System.out.println("Resultado 1: " + incrementCounter(5)); // Resultado 1: 5
        System.out.println("Resultado 2: " + incrementCounter(5)); // Resultado 1: 10
    }

}
