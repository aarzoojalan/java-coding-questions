package com.arz.coding.interviewcodepractise;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamFunctions {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,10,25);
        //1.find out all the numbers starting with 1 using Stream functions
        myList.stream().filter(s-> s > 0 && String.valueOf(s).startsWith("1")).forEach(System.out::println);
        //2.find duplicate elements in a given integers list in java using Stream functions
        Set<Integer> set = new HashSet<>();
        myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);
        //3.find the first element of the list using Stream functions
        myList.stream().findFirst().ifPresent(System.out::println);
        //4.find the total number of elements present in the list using Stream functions
        long count =  myList.stream().count();
        System.out.println(count);
    }
}
