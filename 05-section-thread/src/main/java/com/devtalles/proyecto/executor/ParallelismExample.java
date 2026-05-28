package com.devtalles.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelismExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ejecutando");
        ExecutorService multiThreadPool = Executors.newFixedThreadPool(3);

        long start = System.currentTimeMillis();
        multiThreadPool.submit(() -> task("Tarea A"));
        multiThreadPool.submit(() -> task("Tarea B"));
        multiThreadPool.submit(() -> task("Tarea C"));

        multiThreadPool.shutdown();

        if (!multiThreadPool.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Tareas demoradas, forzando salida");
            multiThreadPool.shutdown();
        }

        long end = System.currentTimeMillis();

        System.out.println("Tiempo total: " + (end - start) + " ms");
    }

    public static void task(String name) {
        System.out.println("Iniciando la " + name + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Tarea completada en hilo " + Thread.currentThread().getName());
    }
}
