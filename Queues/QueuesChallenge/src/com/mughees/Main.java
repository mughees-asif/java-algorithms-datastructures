package com.mughees;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {
        Stack stack = new Stack();
        string = string.toLowerCase().replaceAll("\\W", "");
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        String reverseString = "";
        while (!stack.isEmpty()) {
            reverseString = reverseString + stack.pop();
        }
        return string.equals(reverseString);
    }
}
