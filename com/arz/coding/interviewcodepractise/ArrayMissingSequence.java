package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
public class ArrayMissingSequence {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7,8,10);
        Integer missingSequence = IntStream.rangeClosed(number.get(0),number.get(number.size() -1)).filter(j -> !number.contains(j)).findFirst().orElse(-1);
        System.out.println("missing sequence is "+missingSequence );

        // Another way to do this.
        //IntStream.rangeClosed(number.get(0),number.get(number.size() -1)).boxed().filter(j -> !number.contains(j)).findFirst().ifPresent(System.out::println);
    }
}

