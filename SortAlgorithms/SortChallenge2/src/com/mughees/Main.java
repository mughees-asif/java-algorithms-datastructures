package com.mughees;

public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

    }

    static void insertionSortRecursive (int[] input, int n) {
        if (n <= 1) {
            return;
        }

        insertionSortRecursive(input, n-1);

        int last = input[n-1];
        int j = n-2;

        while (j >= 0 && input[j] > last) {
            input[j+1] = input[j];
            j--;
        }
        input[j+1] = last;
    }
}
