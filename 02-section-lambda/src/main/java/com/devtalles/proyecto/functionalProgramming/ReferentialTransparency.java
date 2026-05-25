package com.devtalles.proyecto.functionalProgramming;

public class ReferentialTransparency {
    public static int triple(int x) {
        return x * 3;
    }

    public static void main(String[] args) {
        int result2 = triple(3) + 2; // 11 también

        int result1 = 9 + 2; // 11

        System.out.println("Resultado 1: " + result1);
        System.out.println("Resultado 2: " + result2);
    }
}
