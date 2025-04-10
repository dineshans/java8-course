package com.java8.stream.operators;

import javax.print.DocFlavor;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,1,2,3);

        // convert list to set
        System.out.println(list.stream().collect(Collectors.toSet()));

        // convert ot specific collection
        ArrayDeque<Integer> arrDeque = list.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println(arrDeque);

        // summarizing statics
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,1,2,3);
        IntSummaryStatistics statistics = list1.stream().collect(Collectors.summarizingInt( x -> x));
        System.out.println("Count - " +  statistics.getCount());
        System.out.println("Max - " +  statistics.getMax());
        System.out.println("avg - " +  statistics.getAverage());
        System.out.println("Min - " +  statistics.getMin());
        System.out.println("Sum - " +  statistics.getSum());

        // grouping element - 4-length ke how many words, 5-length how many workds
       List<String> stringList = Arrays.asList("hello", "world", "java", "streams", "collecting");
        Map<Integer, List<String>> collect = stringList.stream().collect(Collectors.groupingBy(String::length));
        //System.out.println(stringList.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(collect);

        // get counting based on length
        Map<Integer, Long> countingCollectors = stringList.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(countingCollectors);

        TreeMap<Integer, Long> collect1 = stringList.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(collect1);

        // partitioning By
        Map<Boolean, List<String>> collect2 = stringList.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)); // {false=[hello, world, java], true=[streams, collecting]}
        System.out.println(collect2);

        // counting word occurrences

        String sentence = "Hello world Hello java world";
        Map<String, Long> collect3 = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println("Word counting : " + collect3);

        // Summing values in map
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // approach - 1
        System.out.println("Summing values in map : " + map.values().stream().reduce(Integer::sum).get());

        // approach - 2
        IntSummaryStatistics collect4 = map.values().stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Summing values in map : " + collect4);

        // approach 3
        System.out.println("Summing values in map : " + map.values().stream().collect(Collectors.summingInt(x -> x)));

        // creating Map fom Stream Elements
        List<String> fruitesList = Arrays.asList("Apple", "Banana", "Orange");
        System.out.println("Map created from List : " + fruitesList.stream().collect(Collectors.toMap(x ->x, v -> v)));

        // creating Map fom Stream Elements if key is duplicates
        List<String> fruitesList1 = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana");
        System.out.println(fruitesList1.stream().collect(Collectors.toMap(x -> x, v -> 1, (x,y) -> x+y)));


        List<Integer> integerList = Arrays.asList(1,2,3,2,3,4,5,5);
        Map<Integer, Long> collect5 = integerList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println("Integer Duplicates from List : " + collect5);


    }
}
