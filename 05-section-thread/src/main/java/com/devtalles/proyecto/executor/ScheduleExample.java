package com.devtalles.proyecto.executor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule(() -> {
            System.out.println("Tarea después de 4 segundos");
        }, 4, TimeUnit.SECONDS);


        executorService.schedule(() -> {
            System.out.println("Tarea después de 5 segundos");
        }, 5, TimeUnit.SECONDS);

        executorService.shutdown();

        // Forma antigua
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Tarea de 2 segundos");
//            }
//        }, 2000);
//        timer.cancel();
    }
}
