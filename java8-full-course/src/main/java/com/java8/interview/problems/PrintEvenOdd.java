package com.java8.interview.problems;

import java.util.*;
import java.util.stream.Collectors;

public class PrintEvenOdd {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        // print even odd using filter, but here 2 list and 2-stream  using
        /*List<Integer> evenNumber = list.stream().filter(i -> i%2 == 0).toList();
        List<Integer> oddNumber = list.stream().filter(i -> i%2 == 1).toList();
        evenNumber.forEach(e -> System.out.print(" " + e));
        System.out.println();
        oddNumber.forEach(e -> System.out.print(" " + e));*/

        // using single stream, use partitionBy methode

        // print in the single line instead of storing into Map
        list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0)).entrySet().stream().forEach(System.out::println);

        // store result in the map
        Map<Boolean, List<Integer>> result = list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(result.get(true));
        System.out.println(result.get(false));
    }
}
