package com.arz.coding.interviewcodepractise;

import java.util.Arrays;

public class StringReverseWord {
    public static void main(String[] args) {
        String text = "Hii aarzoo Hello";

        String reversedText = Arrays.stream(text.split(" "))
                .reduce((word1, word2) -> word2 + " " + word1).get();
        System.out.println(reversedText);

    }
}
