package com.java8.lamda.reduce;

import com.java8.lamda.map.flatemap.CustomerDAO;

import java.util.*;

public class ReductionMethodExample {

    public static void main(String[] args) {

        // reduce is for aggregate the result - means perform sum, multiply kind of operation
        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        // sum of all the element from array
        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        // instead of lambda function, use inbuild reduce funtion
        Integer reduceSumWithInbuildFun = numbers.stream().reduce(Integer::sum).get();
        System.out.println(reduceSumWithInbuildFun);


        // with custom object, find the average salary of Grade A Employee
        // steps -
        // 1) find the employee with grade A
        // 2) then find salary
        double avrSalary = EmployeeDAO.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(avrSalary);

        // find sum of salary of Grade A employee
        double sumSalary = EmployeeDAO.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .sum();

        System.out.println(sumSalary);

    }
}
