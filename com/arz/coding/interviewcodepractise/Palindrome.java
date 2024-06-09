package com.arz.coding.interviewcodepractise;

public class Palindrome {
    public static void main(String[] args) {
        String word = "madam";
        String reverse = "";
        for(int i = word.length() - 1 ; i>=0; i--){
            reverse = reverse + word.charAt(i);
        }
        if(reverse.equals(word)){
            System.out.println("It is a palidrome");
        }
        else{
            System.out.println("It is not a palidrome");
        }
    }
}
