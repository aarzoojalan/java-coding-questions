package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListThreeMaxThreeMin {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        List<Integer> maxThree = list.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println("Three max numbers "+maxThree);

        List<Integer> minThree = list.stream().sorted(Comparator.comparing(Integer::valueOf)).limit(3).toList();
        System.out.println("Three min numbers "+minThree);
    }
}
