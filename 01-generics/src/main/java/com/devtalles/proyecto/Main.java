package com.devtalles.proyecto;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        Box<String> stringBox = new Box<>("Tobías");

        System.out.println(stringBox.getValue());

        Utility.printItem("Tobías", 2);
        Utility.printItem(10);

        MathUtils.sum(2, 2);

    }
}
