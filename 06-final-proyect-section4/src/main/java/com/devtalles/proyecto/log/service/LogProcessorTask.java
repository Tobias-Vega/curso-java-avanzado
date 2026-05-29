package com.devtalles.proyecto.log.service;

import com.devtalles.proyecto.log.model.LogEntity;
import com.devtalles.proyecto.log.model.LogSummary;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class LogProcessorTask implements Callable<LogSummary> {
    private final List<LogEntity> logEntities;

    public LogProcessorTask(List<LogEntity> logEntities) {
        this.logEntities = logEntities;
    }

    @Override
    public LogSummary call() throws Exception {

        System.out.println("Tarea: Procesando " + logEntities.size() + " " +
                "entradas de log en hilo" + Thread.currentThread().getName());
        int totalEntries = logEntities.size();
        List<LogEntity> errorsLogs = logEntities.stream()
                .filter(logEntity -> logEntity.getStatusCode() >= 400)
                .toList();

        int errorCount = errorsLogs.size();
        Set<String> uniqueUsers = logEntities.stream()
                .map(LogEntity::getUser)
                .collect(Collectors.toSet());

        double averageResponseTime = logEntities.stream()
                .mapToInt(LogEntity::getResponseTimeMs)
                .average()
                .orElse(0.0);

        Map<Integer, Long> errorCountsByCode =logEntities.stream()
                .filter(logEntity -> logEntity.getStatusCode() >= 400)
                .collect(Collectors.groupingBy(
                        LogEntity::getStatusCode,
                        Collectors.counting()
                ));

        System.out.println("Finalizando:  " + logEntities.size() + " " +
                "entradas de log en hilo" + Thread.currentThread().getName());

        return new LogSummary(totalEntries, errorCount, uniqueUsers, averageResponseTime, errorCountsByCode);
    }
}
