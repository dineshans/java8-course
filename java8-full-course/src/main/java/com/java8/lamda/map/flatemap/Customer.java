package com.java8.lamda.map.flatemap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private int id;
    private String name;
    private String email;
    private List<String> phoneNumber;
}
