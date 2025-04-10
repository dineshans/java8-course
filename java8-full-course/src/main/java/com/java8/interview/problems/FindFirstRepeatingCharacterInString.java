package com.java8.interview.problems;

import java.util.*;

public class FindFirstRepeatingCharacterInString {

    public static void main(String[] args) {

        String str = "Java Hello";
        Set<Character> seenChar = new HashSet<>();
        Optional<Character> character = str.chars().mapToObj(c -> (char) c).filter(e -> !seenChar.add(e)).findFirst();
        System.out.println(character.get());
    }
}
