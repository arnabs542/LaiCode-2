package com.study.algorithms.class01_binary_search;

public class ClassicalBinarySearch {
  // ascending order
  // 注意：移动下标的原理：确保每次搜索空间会减小，而且不能排除掉有可能的结果
  // 注意：循环的原理：不能陷入死循环（测试1、2个元素）

  // 找target
  public int binarySearch(int[] array, int target) {
    // corner case:
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
