package com.study.algorithms.class01_binary_search;

public class ClassicalBinarySearch {
  public int binarySearch(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) { // 注意， mid太小应该在右侧找。
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
