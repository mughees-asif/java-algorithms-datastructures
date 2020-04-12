package com.mughees;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 1330, 8792, 1594, 4725, 4586, 5729 };
        radixSort(arr, 10, 4);

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void radixSort(int[] input, int radix, int width) {
        for(int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    static void radixSingleSort(int[] input, int pos, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for(int value : input) {
            countArray[getDigit(pos, value, radix)]++;
        }
        // adjust count array
        for(int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(pos, input[tempIndex], radix)]] =
                    input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    static int getDigit(int pos, int value, int radix) {
        return value / (int) Math.pow(radix, pos) % radix;
    }
}
