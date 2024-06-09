package com.arz.coding.interviewcodepractise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class ArrayThirdHighest {
    public static void main(String[] args) {
        int a[] = {3, 1, 6, 3, 4, 8, 9, 2, 6};
        List<Integer> list = Arrays.stream(a).boxed().toList();
        int thirdMaxNumber = list.stream().sorted(Collections.reverseOrder()).toList().get(2);
        System.out.println("Third Highest Number is "+thirdMaxNumber);

        // Another way to do this.
        // int thirdMaxNumber = list.stream().sorted(Collections.reverseOrder()).skip(2).findFirst().get();
    }
}
