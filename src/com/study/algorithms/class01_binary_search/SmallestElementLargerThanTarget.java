package com.study.algorithms.class01_binary_search;

// find the index of the smallest element in A
// that is larger than target

// 返回index

public class SmallestElementLargerThanTarget {
  public int smallestElementLargerThanTarget(int[] array, int target) {
    // [1,2,2,2,3] T = 4
    //          l
    //          r
    //          m

    if (array == null || array.length == 0) {
      return -1;
    }
    // make sure we can find one:
    if (array[array.length - 1] <= target) {
      return -1;
    }

    int left = 0;
    int right = array.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }
}
