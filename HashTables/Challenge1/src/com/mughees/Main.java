package com.mughees;

public class Main {

    public static void main(String[] args) {

        int[] nums = new int[10];
        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
        for (int value : numsToAdd) {
            nums[hash(value)] = value;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
