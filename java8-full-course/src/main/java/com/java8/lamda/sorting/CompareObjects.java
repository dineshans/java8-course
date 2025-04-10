package com.java8.lamda.sorting;

// compare Employee object

import com.java8.dto.Employee;
import com.java8.dto.EmployeeDAO;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CompareObjects {

    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDAO.getEmployeeList();

        // sort employee object based on the salary
        /*Stream<Employee> sorted = employeeList.stream().sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
        sorted.forEach(System.out::print);*/

        // optimization - use method reference or lambda expression
        //employeeList.stream().sorted(Comparator.comparing(emp -> emp.getName())).forEach(System.out::println);

        // or using method reference
        employeeList.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);


    }
}


