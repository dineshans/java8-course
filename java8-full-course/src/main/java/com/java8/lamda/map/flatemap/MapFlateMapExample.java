package com.java8.lamda.map.flatemap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFlateMapExample {

    public static void main(String[] args) {

        List<Customer> customerList = CustomerDAO.getAll();

        // mapping single email into list - one customer will have one email - so one-to-one mapping
        List<String> emailList = customerList.stream().map(Customer::getEmail).toList();
        //emailList.forEach(System.out::println);


        // its will give [397937955, 21654725] [89563865, 2487238947] --> o/p should be single list [ data ]
        // so its not in flattern format
        // its one-to-many mappings
        List<List<String>> phoneList = customerList.stream().map(Customer::getPhoneNumber).toList();
        //phoneList.forEach(System.out::println);

       //so use flatemap as below
        List<String> phoneList1 = customerList.stream().flatMap(customer -> customer.getPhoneNumber().stream()).toList();
        phoneList1.forEach(System.out::println);

        // split with space and get single list
        List<String> list = Arrays.asList("Hello World",
                "Java stream is powerfull",
                "flatMap is useful"
        );
        System.out.println(list.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase) // to make upper case
                .toList());
    }
}
