package com.arz.coding.interviewcodepractise;

public class ArraySecondHighestWithoutJava8 {
    public static void main(String[] args) {
        int a[] = {1,2,3,45,56,87,87,45};
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i=0; i < a.length ; i++){
           if(a[i] > max){
              secondMax = max;
              max = a[i];
           } else if(a[i] > secondMax && a[i] != max){
               secondMax = a[i];
           }
        }
        System.out.println("Second Highest Integer is "+secondMax);
    }
}
