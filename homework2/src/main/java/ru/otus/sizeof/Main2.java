package ru.otus.sizeof;

import org.openjdk.jol.vm.VM;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by daddyingrave on 10/04/2017.
 */
public class Main2 {
    //-Xms1024m -Xmx1024m
    public static void main(String[] args) throws InterruptedException {
        ObjectsMeasurementStand testStand = new ObjectsMeasurementStand();
        String str = new String("");
        int[] array1 = IntStream.generate(() -> 42).limit(100).toArray();
        int[] array2 = IntStream.generate(() -> 42).limit(1000).toArray();
        int[] array3 = IntStream.generate(() -> 42).limit(10000).toArray();

        System.out.println(VM.current().details());

        System.out.println("Trying to determine the size of an empty string:");
        testStand.sizeOf(str);

        System.out.println("Trying to determine the size of array of 100 integers:");
        testStand.sizeOf(array1);

        System.out.println("Trying to determine the size of array of 1000 integers");
        testStand.sizeOf(array2);

        System.out.println("Trying to determine the size of array of 10000 integers");
        testStand.sizeOf(array3);

        System.out.println("Empty string size calculation by average heap");
        testStand.sizeOf();
    }
}