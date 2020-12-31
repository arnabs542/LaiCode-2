package com.study.algorithms.class11_DP_1;

public class LongestAscendingSubArray {
  // Given an unsorted array, find the length of the longest subarray in which the numbers are in
  // ascending order.

  // index    0   1   2   3   4   5   6   7
  // array    7   2   3   1   5   8   9   6
  // M        1   1   2   1   2   3   4   1   --> can be reduced to a "result" variable
  // base case: 0-th is 1
  // induction rule:
  //      case 1: array[i - 1] + 1,       array[i] > array[i - 1]
  //      case 2: 1,                      array[i] <= array[i - 1]

  public int longest(int[] array) {
    // sanity check:
    if (array == null || array.length == 0) {
      return 0;
    }
    int cur = 1;
    int globalMax = 1;
    for (int i = 1; i <= array.length - 1; i++) {
      if (array[i] > array[i - 1]) {
        cur += 1;
        globalMax = Math.max(globalMax, cur);
      } else {
        cur = 1;
      }
    }
    return globalMax;
  }
}
