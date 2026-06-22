package com.devtalles.proyecto.student;

import com.devtalles.proyecto.student.controller.StudentController;
import com.devtalles.proyecto.student.service.StudentService;
import com.devtalles.proyecto.student.stream.StudentStream;
import com.devtalles.proyecto.student.view.StudentConsoleView;

public class App {
    public static void main(String[] args) {
        StudentStream stream = new StudentStream();

//        stream.getStream().subscribe(
//                item -> System.out.println(item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Fin")
//        );
//
//        stream.publish(new Student("Tobías", 20));
//        stream.publish(new Student("Ricardo", 33));
//
//        stream.completed();

        StudentService studentService = new StudentService();
        StudentController studentController = new StudentController(stream, studentService);
        StudentConsoleView view = new StudentConsoleView(studentController);

        view.start();
    }
}
