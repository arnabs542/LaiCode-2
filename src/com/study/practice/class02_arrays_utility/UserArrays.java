package com.study.practice.class02_arrays_utility;

import java.util.Arrays;
import java.util.Random;

public class UserArrays {
    public static void main(String[] args) {
        int[] array = new int[24];
        int max = 10;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            Random rand = new Random();
            array[i] = min + rand.nextInt((max - min) + 1);
        }
        // 0: toString很好用
        System.out.println(Arrays.toString(array));

        // 1: 测试binarySearch
        int res = Arrays.binarySearch(array, 0); // -1 or index, 多个的时候返回先找到的那个
        System.out.printf("index is %d\n", res);

        // 2: 测试sort
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // 原地修改
    }
}
// Test
