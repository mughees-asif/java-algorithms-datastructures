package com.mughees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

        System.out.println("================================");

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
        Queue<Character> queue = new LinkedList<>();
        string = string.toLowerCase().replaceAll("\\W", "");
        for (int i = string.length() - 1; i >= 0; i--) {
            queue.add(string.charAt(i));
        }
        StringBuilder reverseString = new StringBuilder();
        while (!queue.isEmpty()) {
            reverseString.append(queue.remove());
        }
        return string.equals(reverseString.toString());
    }

    public static boolean checkForPalindrome2(String string) {

        /* Example:-
            "dad"
                1. stack: push(d), push(a), push(d) : d, a, d [Last In, First Out]
                2. queue: add(d), add(a), add(d)    : d, a, a [First In, First Out]
        */

        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            // removes all punctuation and whitespace
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.addLast(c);
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }
        return true;
    }
}
