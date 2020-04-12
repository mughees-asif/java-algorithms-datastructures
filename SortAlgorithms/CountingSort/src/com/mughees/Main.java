package com.mughees;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 8, 2, 8, 7, 10, 54, 3 };
        countingSort(arr, 2, 54);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void countingSort (int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];
        for(int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;

        for (int i = min; i <= max; i++) {
            while(countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i -min]--;
            }
        }
    }
}
