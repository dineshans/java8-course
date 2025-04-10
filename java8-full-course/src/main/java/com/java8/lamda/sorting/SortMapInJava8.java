package com.java8.lamda.sorting;

import com.java8.dto.Employee;

import java.util.*;

public class SortMapInJava8 {

    public static void main(String[] args) {

        Map<Employee, Integer> employeeMap = new HashMap<>();
        employeeMap.put(new Employee(100, "Dinesh", "IT", 100000), 40);
        employeeMap.put(new Employee(100, "Vikash", "CIVIL", 900000), 60);
        employeeMap.put(new Employee(100, "Vimal", "DEFENCE", 500000), 80);
        employeeMap.put(new Employee(100, "Sourav", "CORE", 400000), 100);
        employeeMap.put(new Employee(100, "Vimal", "DEFENCE", 700000), 120);
        employeeMap.put(new Employee(100, "Rajani", "SOCIAL", 1200000), 140);

        // sort map using custom class, based on key cox key is custom object
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);
    }
}
