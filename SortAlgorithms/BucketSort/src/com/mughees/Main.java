package com.mughees;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = { 54, 46, 83, 66, 94, 92, 43 };

        for (int value : array) {
            System.out.println(value);
        }
    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value : input) {
            buckets[hash(value)].add(value);
        }
    }

    private static int hash(int value) {
        return value / (int) 10;
    }
}
