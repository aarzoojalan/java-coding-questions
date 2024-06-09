package com.arz.coding.interviewcodepractise;

public class StringWithoutLength {
    public static void main(String[] args) {
        String s ="aarzoo";
        int length = 0;
        for(char c : s.toCharArray()){
            length = length +1;
        }
        System.out.println(length);
    }
}
