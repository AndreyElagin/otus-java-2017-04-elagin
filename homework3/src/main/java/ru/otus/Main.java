package ru.otus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by daddyingrave on 20/04/2017.
 */
public class Main {
    private static int COUNT = 100;

    public static void main(String[] args) throws InterruptedException {
        List<String> myArrayList = new MyArrayList<>();
        List<String> arrayList = new ArrayList<>();
        String[] arr = new String[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(i);
        }

        System.out.println("Benchmark for ArrayList on addAll method");
        benchmark(() -> {
            Collections.addAll(arrayList, arr);
        });

        System.gc();
        Thread.sleep(10);

        System.out.println("Benchmark for MyArrayList on addAll method");
        benchmark(() -> {
            Collections.addAll(myArrayList, arr);
        });

        System.out.println("\n");
        System.gc();
        Thread.sleep(10);

        System.out.println("Benchmark for ArrayList on copy method");
        benchmark(() -> {
            Collections.copy(arrayList, myArrayList);
        });

        System.gc();
        Thread.sleep(10);

        System.out.println("Benchmark for MyArrayList on copy method");
        benchmark(() -> {
            Collections.copy(myArrayList, arrayList);
        });

        System.out.println("\n");
        System.gc();
        Thread.sleep(10);

        System.out.println("Benchmark for ArrayList on sort method");
        benchmark(() -> {
            Collections.sort(arrayList);
        });

        System.gc();
        Thread.sleep(10);

        System.out.println("Benchmark for MyArrayList on sort method");
        benchmark(() -> {
            Collections.sort(myArrayList);
        });

    }

    public static void benchmark(Runnable runnable) {
        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            runnable.run();
        }
        long end = System.nanoTime();
        long average = (end - start) / COUNT;
        System.out.println("takes a " + average + "ns. " + "Average: " + (average / 100000) + "ns");
    }
}
