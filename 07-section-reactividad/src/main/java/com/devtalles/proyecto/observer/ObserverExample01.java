package com.devtalles.proyecto.observer;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObserverExample01 {
    public static void main(String[] args) {
        Observable<String> courseStream = Observable
                .fromIterable(Arrays.asList("HTML", "CSS", null, "C").stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toSet())
                );

        courseStream.subscribe(
                item -> System.out.println("Recibido: " + item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Fin")
        );
    }
}
