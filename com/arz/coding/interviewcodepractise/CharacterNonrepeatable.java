package com.arz.coding.interviewcodepractise;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterNonrepeatable {
    public static void main(String[] args) {
        String s = "this this is is done by Saket Saket";
        Map<Character,Long> freq = s.chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        // first non repeat character
        s.chars().mapToObj(c -> (char) c).filter(c -> freq.get(c) == 1).findFirst().ifPresent(System.out::println);
        // find all non repeat characters
        s.chars().mapToObj(c -> (char) c).filter(c -> freq.get(c) == 1).forEach(System.out::println);
    }
}
