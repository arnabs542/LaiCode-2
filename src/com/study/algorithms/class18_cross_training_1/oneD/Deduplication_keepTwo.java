package com.study.algorithms.class18_cross_training_1.oneD;

import java.util.Arrays;

public class Deduplication_keepTwo {
  // keep at most two of duplicated elements
  // r
  // w
  // case 1: a[r] == a[w-2] (== a[w-1]) : skip
  // case 2: else --> copy

  public int[] dedup(int[] array) {
    // corner case:
    if (array == null || array.length <= 2) {
      return array;
    }

    // reader and writer
    int r = 2;
    int w = 2;
    while (r < array.length) {
      if (array[r] == array[w - 2]) {
        r++;
      } else {
        array[w++] = array[r++];
      }
    }
    return Arrays.copyOf(array, w);
  }
}
