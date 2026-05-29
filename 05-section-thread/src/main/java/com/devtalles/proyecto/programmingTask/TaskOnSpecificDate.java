package com.devtalles.proyecto.programmingTask;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskOnSpecificDate {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2026, 5, 29, 12,52);
        LocalDateTime now = LocalDateTime.now();

        long delay = Duration.between(now, dateTime).toMillis();

        if (delay < 0) {
            System.out.println("La fecha ya pasó");
            return;
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule(() -> {
            System.out.println("Tarea después de 4 segundos");
        }, delay, TimeUnit.MILLISECONDS);


    }
}
