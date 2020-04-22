package com.mughees;

import java.util.LinkedList;
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

        System.out.println("===================================");

        // should return true
        System.out.println(checkForPalindrome2("abccba"));
        // should return true
        System.out.println(checkForPalindrome2("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome2("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome2("hello"));
        // should return true
        System.out.println(checkForPalindrome2("Don't nod"));
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

    public static boolean checkForPalindrome2(String string) {
        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder noPunctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z') {
                noPunctuation.append(c);
                stack.push(c);
            }
        }
        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }
        return reversedString.toString().equals(noPunctuation.toString());
    }
}