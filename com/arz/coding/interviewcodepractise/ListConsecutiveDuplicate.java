package com.arz.coding.interviewcodepractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListConsecutiveDuplicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,5,6,6,7,9,9,10,23,23,23,6,15);
        // remove only consecutive sequence from a list of Integers
        Integer prev = null;
        List<Integer> desiredList = new ArrayList<>();
        for(Integer num : list){
            if(!num.equals(prev)){
                desiredList.add(num);
                prev = num;
            }
        }
        System.out.println(desiredList);
    }
}
