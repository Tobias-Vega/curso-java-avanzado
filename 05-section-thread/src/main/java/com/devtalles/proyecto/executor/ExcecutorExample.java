package com.devtalles.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(() -> System.out.println("Tarea A " + Thread.currentThread().getName()));
        executor.execute(() -> System.out.println("Tarea B " + Thread.currentThread().getName()));
        executor.execute(() -> System.out.println("Tarea C " + Thread.currentThread().getName()));
        executor.shutdown();
    }
}
