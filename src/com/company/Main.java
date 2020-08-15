package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Folositi exemplele aici
    }

    private static void sideEffects() {
        // Sir cu un singur element care contine valoarea ceruta, incercati sa transformati sirul intr-un simplu
        // Integer, si vedeti ce se intampla
        Integer[] val = new Integer[]{0};
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().forEach(i -> val[0]++);
        System.out.println(val[0]);

    }

    private static void filterEx() {
        // List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<IntWrapper> wrappers = Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .map(IntWrapper::new)
                .collect(Collectors.toList());
        // wrappers.stream().filter(wr -> wr.isEven()).forEach(System.out::println);
        wrappers.stream().filter(IntWrapper::isEven).forEach(System.out::println);

    }

    private static void mapEx() {
        List<Integer> ints = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> doubleValues = ints.stream().map(i -> i * 2).collect(Collectors.toList());
        doubleValues.stream().forEach(System.out::println);

        // Echivalent cu
        // ints.stream().map(i -> i * 2).forEach(System.out::println);

        // List<IntWrapper> wrappers = ints.stream().map(i -> new IntWrapper(i)).collect(Collectors.toList());
        // Echivalent cu
        List<IntWrapper> wrappers = ints.stream().map(IntWrapper::new).collect(Collectors.toList());
        wrappers.forEach(System.out::println);
    }

    private static void forEachEx() {
        List<Integer> ints = Arrays.asList(10, 20, 30, 40, 50);

        // for (Integer i : ints) {
        //     System.out.println(i);
        // }

        ints.stream().forEach(i -> System.out.println(i));
        ints.stream().forEach(System.out::println);

    }

    private static void printWrappers(List<IntWrapper> wrappers) {
        wrappers.forEach(System.out::println);
    }

    private static <T> void printList(List<T> list) {
        // val++;
        System.out.print("[");
        list.stream().forEach(System.out::println);
        System.out.print("]");
    }

    private static void more() {
        List<IntWrapper> wrappers = Stream.iterate(0, i -> i + 1).limit(10).map(i -> new IntWrapper(i * 10)).collect(Collectors.toList());

        printList(wrappers.stream().map(IntWrapper::next).collect(Collectors.toList()));
        printList(wrappers.stream().map(wrapper -> wrapper.isEven()).collect(Collectors.toList()));
    }
}
