package com.java8.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(100, "Dinesh", "IT", 100000));
        list.add(new Employee(100, "Vikash", "CIVIL", 900000));
        list.add(new Employee(100, "Vimal", "DEFENCE", 500000));
        list.add(new Employee(100, "Sourav", "CORE", 400000));
        list.add(new Employee(100, "Vimal", "DEFENCE", 700000));
        list.add(new Employee(100, "Rajani", "SOCIAL", 1200000));
        return list;
    }
}
