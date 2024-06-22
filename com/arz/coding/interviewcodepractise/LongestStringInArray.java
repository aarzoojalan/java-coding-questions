package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
public class LongestStringInArray {
    public static void main(String[] args) {
        String[] atrArray = {"java", "techie","springboot","microservices"};
        String longestString = Arrays.stream(atrArray).max((a,b) -> a.length() - b.length()).get();
        System.out.println(longestString);
    }
}
