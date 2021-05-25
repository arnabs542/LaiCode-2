package com.study.algorithms.class07_Heap_and_Graph_Search;

import java.util.Arrays;

public class Tester {
    public static void main(String args[]) {
        KSmallest_MaxHeap kSmallest_maxHeap = new KSmallest_MaxHeap();
        int[] array = new int[]{5,3,4,2,1,1,2,1,8,4,4,9,13,5,8};
        System.out.println(Arrays.toString(kSmallest_maxHeap.kSmallest(array, 5)));
    }
}
