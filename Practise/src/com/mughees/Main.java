package com.mughees;

import java.util.Arrays;

class Main {

    public static void main(String args[]) {
        int[] array = { 20, 35, -15, 7, 55, 1, -22 };

        for(int gap = array.length/2; gap > 0; gap /= 2) {
            for(int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[i] = newElement;
            }
        }

        for (int value : array) {
            // System.out.println(value);
        }

        miniMaxSum(new int[]{256741038, 623958417, 467905213, 714532089, 938071625});
    }

    static void swap(int[] arr, int a, int b) {
        if (a == b ) {
            return;
        } else {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    static void miniMaxSum(int[] arr) {
        // sorting the array to make sure the smallest and largest values are in the correct index
        for(int gap = arr.length/2; gap > 0; gap /= 2) {
            for(int i = 0; i < arr.length; i++) {
                int newElement = arr[i];
                int j = i;

                while(j >= gap && arr[j - gap] > newElement) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = newElement;
            }
        }
        // calculating the sum of the largest and smallest numbers
        long sum = 0;
        for(long i : arr) {
            sum += i;
            System.out.println(i + "\t" + sum);
        }
        System.out.println(sum);
        long largest = sum - arr[0];
        long smallest = sum - arr[arr.length-1];
        System.out.println(smallest + " " + largest);
    }

}