package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringWithoutLowerCase {
    public static void main(String[] args) {
        String str = "aarzoo jalan";
        String upperCaseString = Arrays.stream(str.split(""))
                .map(s -> s.charAt(0) >= 'a' && s.charAt(0) <='z' ? String.valueOf((char)(s.charAt(0) -32)) : s)
                .collect(Collectors.joining());
        System.out.println(upperCaseString);
    }
}
