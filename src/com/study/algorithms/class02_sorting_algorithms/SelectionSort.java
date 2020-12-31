package com.study.algorithms.class02_sorting_algorithms;

public class SelectionSort {
  public int[] selectionSort(int[] array) {
    // sanity check - null, empty
    if (array == null || array.length <= 1) {
      return array;
    }
    // find the min of [i, length-1]
    for (int i = 0; i < array.length - 1; i++) {
      // 优化1，最后一个一定是已经ok的。所以i不用走到最后一位
      int minIndex = i;
      for (int j = i + 1; j <= array.length - 1; j++) {
        // 优化2，j从i后面一个开始，一直走到最后一位
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      swap(array, i, minIndex);
    }
    return array;
  }

  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
