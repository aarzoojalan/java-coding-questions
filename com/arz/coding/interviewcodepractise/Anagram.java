package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
public class Anagram {
    public static void main(String[] args) {
        String a  = "zaappz";
        String b = "aarzoo";
        boolean status;
        char[] aString = a.toLowerCase().toCharArray();
        char[] bString = b.toLowerCase().toCharArray();
        Arrays.sort(aString);
        Arrays.sort(bString);
        status = Arrays.equals(aString,bString);
        System.out.println(status ? "It is anagram" : "It is not anagram");
    }
}
