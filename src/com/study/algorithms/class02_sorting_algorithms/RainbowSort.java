package com.study.algorithms.class02_sorting_algorithms;

public class RainbowSort {
  public void swap(int[] array, int x, int y) {
    int temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }

  public int[] rainbowSort(int[] array) {
    // [red] [green] [white] [blue]
    //        i       j   k
    if (array == null || array.length <= 1) {
      return array;
    }
    int i = 0;
    int j = 0;
    int k = array.length - 1;
    while (j <= k) { // white is not empty(j == k is still not empty!)
      if (array[j] == -1) {
        // case 1, is red, swap with i, i++, j++
        swap(array, i, j);
        i++;
        j++;
      } else if (array[j] == 0) {
        // case 2, is green, j++
        j++;
      } else if (array[j] == 1) {
        // case 3, is blue, swap with k, k--
        swap(array, j, k);
        k--;
      }
    }
    return array;
  }
}
