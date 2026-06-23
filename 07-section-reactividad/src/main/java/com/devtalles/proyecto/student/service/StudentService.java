package com.devtalles.proyecto.student.service;

import com.devtalles.proyecto.student.model.Student;
import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void subscribeTo(Observable<Student> stream) {
        stream.subscribe(
                student -> {
                    System.out.println("Agregando estudiante..." + student);
                    students.add(student);
                },
                error -> System.out.println(error.getMessage()),
                () -> {
                    System.out.println("Stream completo. Estudiantes cargados...");
                    students.forEach(System.out::println);
                    showStatics();
                }
        );
    }

    private void showStatics() {
        System.out.println("Estadísticas");
        System.out.println("Total: " + students.size());

        if (!students.isEmpty()) {
            double ageAverage = students.stream()
                    .mapToInt(Student::getAge)
                    .average()
                    .orElse(0);

            System.out.println("Promedio de edad: " + ageAverage);
        }

    }

    public Observable<Student> verifyStudent(Student student) throws InterruptedException {
        return Observable.create(emitter -> {
            System.out.println("Verificando..." + student.getName());
            Thread.sleep(1000);

            if (student.getAge() >= 18) {
                emitter.onNext(student);
            } else {
                System.out.println("Estudiante es menor de edad..." + student.getName());
            }

            emitter.onComplete();
        });
    }
}
