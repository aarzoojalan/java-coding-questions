package com.arz.coding.interviewcodepractise;

import java.util.Arrays;

public class StringWordCount {
    // word count in string
    public static void main(String[] args) {
        String s = "My name is Aarzoo";
        long count = Arrays.stream(s.split(" ")).count();
        System.out.println(count);
    }
}
