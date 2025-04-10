package com.java8.funtionalinterface;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
* Predicate is use for conditional startement check
*
* it will have boolean test(argument) method which return boolean
* */
/*public class PredicateDemo implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        if(integer % 2 == 0) {
            System.out.println("even number");
            return true;
        } else {
            System.out.println("Odd number");
            return false;
        }
    }

    public static void main(String[] args) {
        PredicateDemo predicateDemo = new PredicateDemo();
        System.out.println(predicateDemo.test(4));
    }
}*/

// optimization - no need to implement, follow below approach
public class PredicateDemo {

    public static void main(String[] args) {
        /*Predicate<Integer> predicate = (t) -> {
            if(t % 2 == 0) {
                System.out.println("even number");
                return true;
            } else {
                System.out.println("Odd number");
                return false;
            }
        };
       System.out.println(predicate.test(4));*/

        // optimize the code as below
        // create 2-predicate, 1 for even and 1 for odd
        Predicate<Integer> evenPredicate = t -> t % 2 == 0;
        Predicate<Integer> oddPredicate = t -> t % 2 == 1;
        System.out.println(evenPredicate.test(4));
        System.out.println(evenPredicate.test(5));
    }

}