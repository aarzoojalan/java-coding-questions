package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class ListSecondHighestDuplicateSequence {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,5,6,6,7,9,9,10,23,23,23,6,15);
        int secondMax = list.stream().collect(Collectors.toSet()).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondMax);
    }
}
