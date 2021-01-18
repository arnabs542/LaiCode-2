package com.study.algorithms.class18_cross_training_1.oneD;

import java.util.Arrays;

public class Deduplication {
  public int[] dedup(int[] array) {
    // Assumption:
    // input: array
    // output: 1. array (just for auto testing)
    //         2. the length of processed part (in-place)


    // 1 2 2 2 1 3 --> 1213
    // high level:
    // 两个指针，物理意义
    // r: reader -> the index being evaluating
    // w: writer -> the place to write, before it is the processed part.

    // corner case:
    if (array == null || array.length <= 1) {
      return array;
    }

    // two pointers:
    int r = 1; //reader
    int w = 1; //writer

    while (r < array.length) {
      // case 1:
      if (array[r] == array[w - 1]) {
        r++;
      } else {
        array[w] = array[r];
        w++;
        r++;
      }
    }

    return Arrays.copyOf(array, w);
  }
}
