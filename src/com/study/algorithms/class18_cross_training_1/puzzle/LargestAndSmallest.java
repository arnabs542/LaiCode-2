package com.study.algorithms.class18_cross_training_1.puzzle;
// Use the least number of comparisons to get
// the largest and smallest number in the given integer array.
// Return the largest number and the smallest number.
public class LargestAndSmallest {
  // Step 1: split the numbers into winners and losers --- n/2
  // Step 2: compute the min from the losers -- n/2-1
  // Step 3: compute the max from the winners -- n/2-1
  // 类似体育比赛，冠军不可能是失败过的那一组里的人
  // 另外，如果是金字塔型的比赛章程，那么亚军只可能是被冠军直接击败的人，那就是SecondLargest的解法思路。

  // total # of comparisons = 1.5n

  public int[] largestAndSmallest(int[] array) {
    // assumption:
    // 1. input int array, not null, not empty
    // 2. output the {largest, smallest}

    // step 1: split the numbers into winners and losers:
    // meaning: left half store the winners, right half store the losers
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      // indices(i, n-1 - i) will be paired up, the larger one will stay in left part.
      if (array[i] < array[n - 1 -i]) {
        swap(array, i, n - 1 - i);
      }
    }
    // 注意考虑奇数的情况，奇数时index为n/2的[即(n-1)/2的]要在largest、smallest都参与比较
    // step2: find the largest one in winners
    int largest = findLargest(array, 0, (n - 1) / 2); // Notice, 偶数4的左侧2个，则是0,1.   4/2 = 2,  (4-1)/2 = 1
    // step3: find the smallest one in losers:
    int smallest = findSmallest(array, n / 2, n - 1);
    return new int[] {largest, smallest};
  }

  private int findLargest(int[] array, int left, int right) {
    // int max = Integer.MIN_VALUE;
    int max = array[left];
    for (int i = left + 1; i <= right; i++) {
      max = Math.max(array[i], max);
    }
    return max;
  }

  private int findSmallest(int[] array, int left, int right) {
    int min = array[left];
    for (int i = left + 1; i <= right; i++) {
      min = Math.min(array[i], min);
    }
    return min;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
