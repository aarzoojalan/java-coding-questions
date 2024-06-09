package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListFirstDuplicateNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,2,0,2,6,6,6,1,8,8,9);

        Map<Integer,Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Integer firstDuplicate = list.stream().filter(e -> e > 1 && map.get(e) > 1).findFirst().orElse(null);
        System.out.println(firstDuplicate);
    }
}
