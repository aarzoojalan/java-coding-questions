package com.arz.coding.interviewcodepractise;

import java.util.stream.IntStream;

public class StringAlternateChar {
    public static void main(String[] args) {
        String s = "WELCOME";
        IntStream.rangeClosed(0, s.length())
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(s.charAt(i)));
    }
}
