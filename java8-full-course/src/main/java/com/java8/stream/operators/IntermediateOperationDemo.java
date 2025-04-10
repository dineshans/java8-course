package com.java8.stream.operators;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationDemo {

    public static void main(String[] args) {

        long count = Stream.iterate(1, x -> x++).limit(10).skip(1).count();
        System.out.println(count);

        Stream<String> streamOfStrings = Stream.of("Dinesh", "Shubham", "Raj", "Ankit", "Dinesh");
        //System.out.println(streamOfStrings.filter(x -> x.startsWith("A")).distinct().collect(Collectors.toList()));

        // distinct without filter
        //System.out.println(streamOfStrings.distinct().collect(Collectors.toList()));

        // find names where length is more than 3
        System.out.println(streamOfStrings.filter(x -> x.length() > 3).collect(Collectors.toList()));

        // given a string, find first repeating character
        String str = "Shubham";
        Set<Character> set = new HashSet<>();
        Character repeatingCharacter = str.chars()
                .mapToObj(c -> (char) c)
                .filter(e -> !set.add(e))
                .findFirst()
                .get();

        //System.out.println("Repeating character : " + repeatingCharacter);

        // find count of repeating characters
        Set<Character> set1 = new HashSet<>();
        String str1 = "ababc";
        Long countOfRepeatingCharacters = str1.chars().mapToObj(c -> (char) c).filter(e -> !set1.add(e)).count();
        //System.out.println("Repeating characters count : " + countOfRepeatingCharacters);



        List<Integer> list = Stream.of(1,2,3,4,5).toList();
        // squaring and sorting the elements
       System.out.println(list.stream().map(x -> x*x).sorted().collect(Collectors.toList()));

       // summing values
        System.out.println(list.stream().reduce(Integer::sum).get());

        // counting occurrence of numbers
        String s = "Hello World";
        System.out.println(s.chars().mapToObj(c -> (char) c).filter(ch -> ch == 'l').count());


    }
}
