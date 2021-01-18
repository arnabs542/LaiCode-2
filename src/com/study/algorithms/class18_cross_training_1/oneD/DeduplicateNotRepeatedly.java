package com.study.algorithms.class18_cross_training_1.oneD;

import java.util.Arrays;

public class DeduplicateNotRepeatedly {
  // 1 2 2 2 1 3 --> 1 1 3
  // 不再是 3, 也不是 1 2 1 3

  // 和上一题不一样，不是linear scan回头看。
  // 即，遇到了第二个1的时候，不用去看w-1的位置（即stack top）

  // 这一题的做法，差距比较大，其实是run-length coding，要一段一段地做压缩
  // f'从f一直向右移动，直到f'和之前的f不一样。

  // 1 2 2 2 1 3 --> 1 1 3
  //   s
  //   f
  //         f' (f' - f == 3)
  // 图示的下一步，是f直接跳到f'的位置。随后发现走case1，copy

  // Initialize: s = f = 0
  // For each step:
  //   f' = f
  //   keep f'++ until a[f'] != a[f]
  //   a[f...f'] is a segment:
  //          case1: if f'-f == 1, copy, f = f'
  //          case2: else        , ignore, f = f'
  public int[] dedup(int[] array) {
    if (array == null) {
      return array;
    }

    int r = 0; // 要从头开始！不能跳过！每个segment都要处理到
    int w = 0;
    while (r < array.length) {
      // probing
      int r2 = r;
      while (r2 < array.length && array[r2] == array[r]) {
        r2++;
      }
      // executing based on probed result
      if (r2 - r == 1) {
        // copy and move
        array[w] = array[r];
        r = r2;
        w++;
      } else {
        r = r2;
      }
    }
    return Arrays.copyOf(array, w);
  }
}
