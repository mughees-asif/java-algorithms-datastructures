package com.mughees;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 20, 35, -15, 7, 55, 1, -22 };

        mergeSort(arr, 0, arr.length);

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(input, start, mid); // left partition
        mergeSort(input, mid, end); // right partition
        merge(input, start, mid, end);

    }

    static void merge(int[] input, int start, int mid, int end) {
        if(input[mid - 1] >= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
