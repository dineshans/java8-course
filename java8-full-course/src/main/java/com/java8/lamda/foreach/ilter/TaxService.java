package com.java8.lamda.foreach.ilter;

import com.java8.dto.Employee;
import com.java8.dto.EmployeeDAO;

import java.util.List;
import java.util.function.Predicate;

public class TaxService {

    public static void main(String[] args) {

        // find the employee who is eligible to pay the tax - salary < 500000

        List<Employee> employeeList = EmployeeDAO.getEmployeeList();

        // get emp whoe salary is less than 500000, not eligible to pay tax
        List<Employee> employees = employeeList.stream().filter(emp -> emp.getSalary() < 500000).toList();
        System.out.println("Employee not eligible to pay tax : ");
        employees.forEach(e -> System.out.print(" " + e));
        System.out.println();

        // get employee whose salary is 500000 and more than 500000, libel to pay tax
        List<Employee> employees1 = employeeList.stream().filter(emp -> emp.getSalary() >= 500000).toList();
        System.out.println("Employee eligible to pay tax : ");
        employees1.forEach(e -> System.out.print(" " + e));
        System.out.println();

        // instead of filtering like this, create 2 predicates and merge both

        Predicate<Employee> predicate1 = employee -> employee.getSalary() > 500000;
        Predicate<Employee> predicate2 = employee -> employee.getSalary() < 800000;
        Predicate<Employee> compbinedPredicate = predicate1.and(predicate2);
        List<Employee> predicateList = employeeList.stream().filter(compbinedPredicate).toList();
        System.out.println("Predicate combined list : ");
        predicateList.forEach(e -> System.out.print(" " + e));

    }
}