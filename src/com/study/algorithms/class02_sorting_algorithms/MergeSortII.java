package com.study.algorithms.class02_sorting_algorithms;

public class MergeSortII {
    // 疑问：
    // 1. 使用buffer的时候，copy回去时，如果left <= right，为啥不直接left++/cur++，而是还要复制一次呢？
    // 试试这个例子就知道了： cur和left只要有一次不同步，那么就必须要指定copy过去的位置了
    //          1 3 2 4
    //          l
    //              r
    // 难点：
    // 1. 后处理，只需要对left做。
    // 2. left，right是buffer的概念，cur是array的概念。

    // 我要：我给你一个int array，你给我返回sort好的array
    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] buffer = new int[array.length];
        return mergeSort(array, buffer, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int[] buffer, int start, int end) {
        // base case
        if (start == end) {
            return array;
        }
        // recursion rule
        int mid = start + (end - start) / 2;
        mergeSort(array, buffer, start, mid);
        mergeSort(array, buffer, mid + 1, end);
        return merge(array, buffer, start, mid, end);
    }

    private int[] merge(int[] array, int[] buffer, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            buffer[i] = array[i];
        }
        // 谁小移谁回去
        int cur = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (buffer[left] <= buffer[right]) {
                array[cur] = buffer[left]; // ??? 这里为什么不能直接移动，而是一定要复制呢？
                left++;
            } else {
                array[cur] = buffer[right];
                right++;
            }
            cur++;
        }
        while (left <= mid) {
            array[cur] = buffer[left];
            left++;
            cur++;
        }
        // 另一个while情况省略了
        return array;
    }
}
