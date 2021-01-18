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
  public int[] moveZero(int[] array) {
    // reader: the index being processing
    // writer: the position to write, left of it (excluding) is the processed part.
    // case 1: a[r] != 0, copy
    // case 2: a[r] == 0, r++
    //  strategy to copy: swap a[w] with a[r] --> don't need post processing

    if (array == null || array.length == 0) {
      return array;
    }

    int r = 0;
    int w = 0;
    while (r < array.length) {
      // case 1:
      if (array[r] == 0) {
        r++;
      } else {
        // case 2:
        swap(array, r++, w++);
      }
    }
    return array;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }


  // 如果是rainbow sort, quick sort思想，则不可以保证相对位置不变：
  // i: next element to evaluate & to write < pivot
  // j: next element to write > pivot
  //  [0, i) < pivot (non-zero)
  //  [i,j] unprocessed
  //  [j+1, n-1] >= pivot (zero)
  public int[] moveZero2(int[] array) {
    // i: start from 0
    // j: start from array.length - 1
    // i is the next place to put non-zero elements
    // j is the next place to put zero elements
    // [i,j] unprocessed

    // case 1: a[i] == 0, swap, j--.
    // case 2: a[i] != 0, i++

    // stop condition: i >= j

    // corner case:
    if (array == null || array.length == 0) {
      return array;
    }

    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      if (array[i] == 0) {
        swap(array, i, j);
        j--;
      } else {
        i++;
      }
    }
    return array;
  }


}
