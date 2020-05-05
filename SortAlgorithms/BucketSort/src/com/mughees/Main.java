package com.mughees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = { 54, 46, 83, 66, 94, 92, 43 };
        bucketSort(array);
        for (int value : array) {
            System.out.println(value);
        }
    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];
        for(int i = 0; i < buckets.length; i++) {
            // using linked lists as buckets, can use other lists
            buckets[i] = new LinkedList<>();
        }

        for (int value : input) {
            buckets[hash(value)].add(value);
        }

        for(List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                input[j++] = value;
            }
        }
    }

    private static int hash(int value) {
        return value / (int) 10;
    }
}
