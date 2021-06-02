package com.study.algorithms.class01_binary_search;
/*
 *  interface Dictionary {
 *    public Integer get(int index);
 *  }
 */

import java.util.Dictionary;
// BS implementation on an dictionary with unknown size.
// assumption:
// 1. the dictionary is an unkown sized sorted array,
//    it only provides get(int index) function, it return null when out of bound
// 2. the elements in the dictionary are all Integers.

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class UnknownSizeBinarySearch {
    // Dict里面，传入index，可以获得对应的value；
    public int search(Dictionary<Integer, Integer> dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0;
        int right = 1;
        // find the right bound

        // You do not need to implement the Dictionary interface.
        // You can use it directly, the implementation is provided when testing your solution.
        while (dict.get(right) != null && dict.get(right) < target) {
            // 1. move left to right
            // 2. double right index
            left = right;
            right = right * 2;
        }
        return binarySearch(dict, target, left, right);
    }

    private int binarySearch(Dictionary<Integer, Integer> dict, int target, int left, int right) {
        // classical binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            } else if (dict.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}