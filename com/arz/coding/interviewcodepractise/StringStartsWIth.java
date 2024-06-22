package com.arz.coding.interviewcodepractise;

import java.util.List;

public class StringStartsWIth {
    public static void main(String[] args) {
        List<String> names = List.of("Mumbai", "Pune", "Delhi", "Agra", "ajmer");
        names.stream().filter(n -> n.toLowerCase().startsWith("a")).forEach(System.out::println);
    }
}
