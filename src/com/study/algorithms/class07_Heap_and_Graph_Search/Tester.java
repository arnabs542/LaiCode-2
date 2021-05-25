package com.study.algorithms.class07_Heap_and_Graph_Search;

import java.util.Arrays;

public class Tester {
    public static void main(String args[]) {
        KSmallest_QuickSelect kSmallest = new KSmallest_QuickSelect();
        int[] array = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(kSmallest.kSmallest(array, 2)));
    }
}
