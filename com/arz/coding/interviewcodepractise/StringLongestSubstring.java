package com.arz.coding.interviewcodepractise;

import java.util.stream.IntStream;

public class StringLongestSubstring {
    public static void main(String[] args) {
        // longest substring in a string
        String s = "ABCDEFGABEFGHIJKLMN";
        String longestSubstring = IntStream.rangeClosed(0, s.length())
                .mapToObj(start -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = start; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (sb.indexOf(String.valueOf(c)) != -1) {
                            break;
                        }
                        sb.append(c);
                    }
                    return sb.toString();
                })
                .max((a, b) -> a.length() - b.length())
                .orElse("");
        System.out.println(longestSubstring);
    }
}
