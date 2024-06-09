package com.arz.coding.interviewcodepractise;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapSortSecondHighest {
    public static void main(String[] args) {
        HashMap<Integer,String> hashmap = new HashMap<>();
        hashmap.put(1,"xyz");
        hashmap.put(2,"Pier");
        hashmap.put(3,"Aarzoo");

        HashMap<Integer,String> sortedHashMap = hashmap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(n,m)-> n,LinkedHashMap::new));
        System.out.println(sortedHashMap);

        String secondHighest = sortedHashMap.values().stream().skip(1).findFirst().orElse(null);
        System.out.println(secondHighest);

    }
}
