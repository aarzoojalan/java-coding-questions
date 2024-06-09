package com.arz.coding.interviewcodepractise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {
    public static void main(String[] args) {
        String a = "This this is is done by Saket Saket";
        
        // count of 1 character
        long countA = a.chars().filter(ch -> ch == 'a').count();
        System.out.println("count of a is "+countA);

        // count of each character
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < a.length(); i++){
            if(map.containsKey(a.charAt(i))){
                int count = map.get(a.charAt(i));
                map.put(a.charAt(i),++count);
            }
            else{
                map.put(a.charAt(i),1);
            }
        }
        System.out.println("frequency of each character" +map);

        // count of each character using java8
        String s = "This this is is done by Saket Saket";
        Map<Character,Long> freqChar = s.chars().mapToObj(c -> (char) c).collect(
                Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("frequency of each character "+freqChar);
    }
}
