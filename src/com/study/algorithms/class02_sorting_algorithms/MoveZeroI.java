package com.study.algorithms.class02_sorting_algorithms;

public class MoveZeroI {
  // 如果是rainbow sort, quick sort思想，则不可以保证相对位置不变：
  // i: next element to evaluate & to write < pivot
  // j: next element to write > pivot
  //  [0, i) < pivot (non-zero)
  //  [i,j] unprocessed
  //  [j+1, n-1] >= pivot (zero)
  public int[] moveZero(int[] array) {
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

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
