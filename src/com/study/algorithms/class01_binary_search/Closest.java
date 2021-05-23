package com.study.algorithms.class01_binary_search;

public class Closest {
  // 1 2 4 7 8 9   target = 5
  //     L
  //       R
  //     M
  // [偶数的M会在靠左这边]

  // 注意，L和R最终可能会挨着，此时应该挑出来，然后比较这俩哪个和target比较近

  // 找与target最接近的, 距离一样的, prefer 小的
  public int closest1(int[] array, int target) {
    // corner case:
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    // loop:
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    // 如果只有1个元素，依然会走到这里。而且left == right == 0
    if (target - array[left] <= array[right] - target) {
      return left;
    } else {
      return right;
    }
  }

  // find the closest, then we cannot exclude the mid
  // 1 2 4           target 3
  //   l
  //   m
  //     r
  // this can be an infinite loop
  public int closest(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }

    int left = 0;
    int right = array.length - 1;
    while (left <= right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    // post:
    if (array[right] - target >= target - array[left]) {
      return left;
    } else {
      return right;
    }
  }
}
