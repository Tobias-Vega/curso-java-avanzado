package com.devtalles.proyecto;

import com.devtalles.proyecto.log.model.LogEntity;
import com.devtalles.proyecto.log.service.LogService;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Iniciando análisis de logs...");

        File logsFolder = new File("logs");
        File[] logFiles = logsFolder.listFiles((dir, name) -> name.endsWith(".log"));

        if (logFiles == null || logFiles.length == 0) {
            System.out.println("No se encontraron archivos .log en la carpeta 'logs'. " +
                    "Asegúrate de crearla y poner archivos dentro");
            return;
        }

        LogService service = new LogService();

        List<LogEntity> entries = service.readLogsFromFile(logFiles[0].getAbsolutePath());

        entries.forEach(System.out::println);
    }
}
