package com.devtalles.proyecto.student;

import com.devtalles.proyecto.student.model.Student;
import com.devtalles.proyecto.student.stream.StudentStream;

public class App {
    public static void main(String[] args) {
        StudentStream stream = new StudentStream();

        stream.getStream().subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Fin")
        );

        stream.publish(new Student("Tobías", 20));
        stream.publish(new Student("Ricardo", 33));

        stream.completed();
    }
}
