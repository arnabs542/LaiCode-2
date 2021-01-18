package com.study.algorithms.class18_cross_training_1.oneD;

public class MoveZerosToTheEnd {
  //  {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0},
  //    it should be changed to
  //  {1, 9, 8, 2, 7, 4, 6, 0, 0, 0, 0}

  // A similar problem: remove all zeros from the input array, 本题需要补零罢了。

  // 同向而行的两个pointer, 可以让相对位置不变：
  // f: the index being processed
  // s: a[0, s-1] are processed and should be kept
  // initliaze: s = 0, f = 0
  // for each step:
  //   case 1: a[f] == 0, then f++;
  //   case 2: else,      copy, s++, f++;
  // then, a[s++]=0 until s == a.length;



  // 如果是rainbow sort, quick sort思想，则不可以保证相对位置不变：
  // i: next element to evaluate & to write < pivot
  // j: next element to write > pivot
  //  [0, i) < pivot (non-zero)
  //  [i,j] unprocessed
  //  [j+1, n-1] >= pivot (zero)



}
