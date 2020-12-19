package com.study.algorithms.class01_binary_search;

// find the index of the smallest element in A
// that is larger than target

// 返回index

public class SmallestElementLargerThanTarget {
    public int smallestElementLargerThanTarget(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array[0] > target) { // 最小的都比target大，答案就是它
            return 0;
        }
        if (array[array.length - 1] <= target) { // 最大的都target小，没有larger
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        // 1,2,4,5,6        t=3
        // l
        //         r
        //     m
        while (left < right - 1) { // left 一旦到达right-1就应该退出进行后处理
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) { //  <= target中，全部排除。
                left = mid + 1;
            } else {  // > target，可能有答案
                right = mid;
            }
        }
        if (array[left] > target) {
            // left更小
            return left;
        } else if (array[right] > target) {
            return right;
        }
        return -1;
    }
}
