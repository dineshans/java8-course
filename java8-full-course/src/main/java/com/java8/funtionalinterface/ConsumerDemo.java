package com.java8.funtionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
    consumer functional interface will have only one abstract method
    void accept(T t) --> it will accept argument but not retrun anything
    so if you want to perform some service login=c using argument and don't want to return anything then use this
 */
public class ConsumerDemo {

    public static void main(String[] args) {

        // this is one way to call
        Consumer<Integer> consumer = (t) -> System.out.println("print : " + t);
        // call consumer interface method using interface reference
        consumer.accept(10);

        // now for each method also taking consumer interface as argument so also can print like below
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().forEach(t -> System.out.println("print: " + t));

    }
}
