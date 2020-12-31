package com.study.algorithms.class01_binary_search;

// 返回index, 等于情况也要排除。
public class LargestElementSmallerThanTarget {
  public int largestElementSmallerThanTarget(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    if (array[0] >= target) { // 最小的都比target大或等于，就没法返回smaller了
      return -1;
    }
    if (array[array.length - 1] < target) { // 最大的都target小，说明就应该返回这个
      return array.length - 1;
    }

    int left = 0;
    int right = array.length - 1;
    // 1,2,4,5,6        t=3
    // l
    //   r
    //  m
    while (left < right - 1) { // left 一旦到达right-1就应该退出进行后处理
      int mid = left + (right - left) / 2;
      if (array[mid] < target) { //  < target 中可能有答案
        left = mid;
      } else {  // >= target都要删掉
        right = mid - 1;
      }
    }
    if (array[right] < target) {
      // right 更大
      return right;
    } else if (array[left] < target) {
      return left;
    }
    return -1;
  }
}
