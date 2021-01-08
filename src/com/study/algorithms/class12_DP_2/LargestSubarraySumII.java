package com.study.algorithms.class12_DP_2;

public class LargestSubarraySumII {
  // 这次，我们还希望返回左右边界。
  // * for循环记得跳过第一个 base rule
  // * 更新tempLeft的时机很重要
  // * 没必要把update phase也拆分成更新左侧和更新右侧两种情况。

  public int[] largestSum(int[] array) {
    // Notice: don't update left/right during induction phase

    // sanity check
    if (array == null || array.length == 0) {
      return null;
    }

    int left = 0;
    int right = 0;
    int tempLeft = 0; // record a candidate of left border.
    int sum = array[0]; // current sum
    int largestSum = array[0]; // global max

    for (int i = 1; i < array.length; i++) {
      // induction rule:
      if (sum < 0) {
        sum = array[i];
        tempLeft = i;
      } else {
        sum += array[i];
      }

      // update largestSum, left, right only when the new sum is larger
      if (sum > largestSum) {
        // we need leftmost one if there are multiple solutions, so > not >=
        left = tempLeft;
        right = i;
        largestSum = sum;
      }
    }
    return new int[]{largestSum, left, right};
  }

}
