package com.study.algorithms.class13_DP_3;

public class LongestConsecutiveOnes {
  public int longest(int[] array) {
    // base rule:
    //    count --> 0
    // induction rule:
    //    count++, if 1
    //    count = 0, if 0

    // sanity check
    if (array == null || array.length == 0) {
      return 0;
    }

    int count = 0;
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        count = 0;
      } else { // array[i] == 1
        count++;
      }

      max = Math.max(max, count);
    }
    return max;
  }
}
