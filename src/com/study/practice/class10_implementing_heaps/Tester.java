package com.study.practice.class10_implementing_heaps;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        int[] array = new int[]{4,4,3,2,-5,1};
        LaiCodeMinHeap laiCodeMinHeap = new LaiCodeMinHeap();

        int[] result = laiCodeMinHeap.heapifyWithPercolateUp(array);
        System.out.println(Arrays.toString(result));

        array = laiCodeMinHeap.heapify(array);
        System.out.println(Arrays.toString(array));

    }
}