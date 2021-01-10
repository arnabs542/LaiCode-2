package com.study.algorithms.class09_bit_representation;

public class MissingNumber {
  // Method 1: XOR

  // One solution is "swapping"



  // Method 2: swap to the original position. - O(n)
  // 不变量：swap的次数是不变的，一个元素只会swap最多一次。所以时间复杂度就是O(n)

  // 第一阶段：
  // index 0 1 2 3 4 5
  // value 1 4 6 7 2 3
  //                   把边界内的不断swap到自己的位置
  //                   边界外的则留着。
  // index 0 1 2 3 4 5
  // value 1 2 3 4 7 6

  // 第二阶段：
  // for loop找不合适的那个元素所在的位置，就是missing number的位置。


  public int missingIV(int[] array) {
    // 第一阶段：
    // try to swap the numbers to its corresponding position.
    // for the number x, the corresponding position is x - 1.
    for (int i = 0; i < array.length; i++) {
      // while array[i] is not i+1, swap array[i] to its correct
      // position if possible.
      while (array[i] != i + 1 && array[i] != array.length + 1) {
        // 不是该有的元素，也不是最大值，那么就swap这个元素到它应该有的位置上。
        swap(array, i, array[i] - 1);
      }
    }

    // 第二阶段：
    // if the missing number is in range of 1 - n-1,
    // then we can find it by checking the index i where array[i] != i+1
    for (int i = 0; i < array.length; i++) {
      if (array[i] != i + 1) {
        return i + 1;
      }
    }
    // if all the numbers of 1 - n-1 are in position,
    // the missing number is n.
    return array.length + 1;
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
  }
}
