package com.study.algorithms.class07_Heap_and_Graph_Search;

/*
  关于Heapify的复杂度计算：

  为何heapify的复杂度是O(n), 是用错位相减法可得。
  1. 一共有k层（1 到 k), 第i层有2^(i-1)个节点需要执行percolateDown --> 每个开销是(k-i)
  2. 错位相减
      cost = (2^0)*(k-1) + (2^1)*(k-2) + ... + (2^k-2)*1   -->  第k-1层不需要进行percolateDown
      cost = 2cost-cost = -k+1 + 2 + 2^2 + ... + 2^k-1  --> 然后要等比数列求和 an=a1×q^(n-1)  a1(1-q^n)/(1-q)
                                                                                a1 = 1, an = 2^k-1, n = k,
      cost = -k + 1(1-2^k)/(1-2) = -k + 2^(k) - 1
  3. 完全二叉树，所以换元 k = logn, cost = -logn + n - 1 = O(n)
* */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Solution 1: 一个maxHeap
// 每个人和maxHeap的max值比较，如果比它还低，就代替掉这个max
// time: O(n)
// space: O(k)

// Solution 2: Quick Select
// 把小的丢到pivot的左边，大的放右边。  此时pivot的位置肯定是对的，看pivot是不是小于等于k了。
// average time: O(n + n/2 + n/4 + ... k) = O(n)
// worst case: O(n^2)
// space: O(n)


// maxHeap --> space O(n) time O(n + klogn) heapify + k popping
// minHeap --> space O(k) time O(k + (n-k)(logk))     主要是空间复杂度差别大。一个log(n), 一个log(k)

public class KSmallest_MaxHeap {
  public int[] kSmallest(int[] array, int k) { // 保证 length > k
    if (array == null || array.length == 0 || k <= 0) {
      return new int[0];
    }

    Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 < o2 ? 1 : -1;
      }
    });
    // init
    for (int i = 0; i < k; i++) {
      maxHeap.offer(array[i]);
    }
    // update
    for (int i = k; i < array.length; i++) {
      if (array[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    // return
    int[] list = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      list[i] = maxHeap.poll(); // ascending order
    }
    return list;
  }
}
