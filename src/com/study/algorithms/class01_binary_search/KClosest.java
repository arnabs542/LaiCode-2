package com.study.algorithms.class01_binary_search;

public class KClosest {

  // closet k elements
  // assumption: assume return an array holding closet k elements.
  // new corner case: k should be not null and k <= array.length. otherwise return empty array.

  // 1 2 4 7 8 9    target = 5, k = 3
  // L
  //           R
  //     M

  // step 1: find out the closet one                    O(log2(n))
  // step 2: post processing, expand L and R 谁小移谁     O(k)

  // 如果有一样的，prefer小的 --> 也是写成 <=

  public int[] MyKClosest(int[] array, int target, int k) {
    // corner case:
    if (array == null || array.length == 0) {
      return array; // 相当于return null 或者 return new int[0]
    }
    int closetIndex = binarySearchClosest(array, target); // prefer小的
    int left = closetIndex;
    int right = closetIndex + 1; // 可能已经越界，一会儿要检查.
    int[] result = new int[k];
    // 难点： 如何编写这个逻辑？
    // hint：
    //  1. 只思考两个分支（加左边或者加右边），不要搞一大堆if else，那样容易漏。
    //  2. 只修改其中一个分支，让它work: 比如何时加左边：
    // - 如果右边到头了，就加左边（保证k比n小）
    // - 如果左边没到头，而且左侧更近，就加左边
    for (int i = 0; i < k; i++) {
      if (right >= array.length ||
              left >= 0 && target - array[left] <= array[right] - target) {
        result[i] = array[left--];
      } else {
        result[i] = array[right++];
      }
    }
    return result;
  }
  // 找与target最接近的, 距离一样的, prefer 小的
  private int binarySearchClosest(int[] array, int target) {
    // corner case:
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    // loop:
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    // 如果只有1个元素，依然会走到这里。而且left == right == 0
    if (target - array[left] <= array[right] - target) {
      return left;
    } else {
      return right;
    }
  }

  public int[] kClosest(int[] array, int target, int k) {
    // 1. find the largest smaller equal (adjust largest smaller)
    // 2. do expansion. - or use the advance version
    if (array == null || array.length == 0) {
      return array;
    }
    if (k == 0) {
      return new int[0];
    }

    int left = largestSmallerEqual(array, target);
    int right = left + 1;
    int[] result = new int[k];
    // 两边开花
    for (int i = 0; i < k; i++) {
      // 都没了返回这个不满的result
      if (left < 0 && right > array.length - 1) {
        return result;
      }
      // 左边没了就加右边
      else if (left < 0) {
        result[i] = array[right];
        right++;
      }
      // 右边没有了就加左边
      else if (right > array.length - 1) {
        result[i] = array[left];
        left--;
      }
      // 都有，就比较大小，谁近移谁
      else {
        if (target - array[left] > array[right] - target) {
          result[i] = array[right];
          right++;
        } else {
          result[i] = array[left];
          left--;
        }
      }
    }
    return result;
  }

  public int largestSmallerEqual(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }
    if (array[0] > target) {
      return -1;
    }
    if (array[array.length - 1] < target) { // 删掉等于。
      return array.length - 1;
    }

    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) { // left 一旦到达right-1就应该退出进行后处理
      int mid = left + (right - left) / 2;
      if (array[mid] <= target) { //  <= target 中可能有答案
        left = mid;
      } else {  // > target都要删掉
        right = mid - 1;
      }
    }
    if (array[right] <= target) {
      // right 更大
      return right;
    } else if (array[left] <= target) {
      return left;
    }
    return -1;
  }
}
