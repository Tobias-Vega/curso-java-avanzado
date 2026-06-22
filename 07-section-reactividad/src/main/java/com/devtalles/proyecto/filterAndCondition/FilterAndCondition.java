package com.devtalles.proyecto.filterAndCondition;

import io.reactivex.rxjava3.core.Observable;

public class FilterAndCondition {
    public static void main(String[] args) {

        Observable<Integer> ages = Observable.just(10, 20, 20, 30, 12, 14, 18, 60, 70);

        //filter
//        ages.filter(age -> age >= 21).subscribe(System.out::println);

        // distinct
//        ages.distinct().subscribe(System.out::println);

        // take
//        ages.take(2).subscribe(System.out::println);

        ages.takeWhile(
                age -> age < 21
        ).subscribe(System.out::println);
    }
}
