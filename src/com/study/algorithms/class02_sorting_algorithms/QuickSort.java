package com.study.algorithms.class02_sorting_algorithms;

import java.util.Random;

public class QuickSort {
  public int[] quickSort(int[] array) {
    // sanity check
    if (array == null || array.length <= 1) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }

  public void quickSort(int[] array, int left, int right) {
    // base case: 1 or 0 element
    if (left >= right) { // == -> 1; > -> 0
      return;
    }

    // define a pivot and use it to partition the array (we need the new index of pivot)
    int pivotIndex = partition(array, left, right);
    // recursively sort the two sub arrays
    quickSort(array, left, pivotIndex);
    // return the sorted array of this level
    quickSort(array, pivotIndex + 1, right);
  }

  public int partition(int[] array, int left, int right) {
    int pivotIndex = getPivotIndex(left, right);
    int pivotValue = array[pivotIndex];
    // swap
    swap(array, pivotIndex, right);
    // partition
    int leftBound = left;     // first "white"
    int rightBound = right - 1; // last "white"
    while (leftBound <= rightBound) {
      // while there are "white" remaining in the array;
      if (array[leftBound] < pivotValue) {
        leftBound++;
      } else {
        swap(array, leftBound, rightBound);
        rightBound--;
      }
    }
    // swap back
    swap(array, leftBound, right);
    return leftBound;
  }

  public void swap(int[] array, int x, int y) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }

  public int getPivotIndex(int left, int right) {
    Random rand = new Random();
    return left + rand.nextInt(right - left + 1);
    // 可以被优化为三个随机数的中位数
  }
}
