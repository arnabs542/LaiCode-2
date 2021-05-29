package com.study.practice.class10_implementing_heaps;

import java.util.Arrays;
import java.util.NoSuchElementException;

// implementation of min heap
// 询问自己：
//   size的意思？
//   offer的时候如何扩容？
//   如何heapify？
//   update的时候如何判断进入哪个分支？

public class MinHeap {
  private int[] array;
  private int size;

  public MinHeap(int[] array) { //可以在这里传入一个Comparator<E> myC
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("input array can not be null or empty");
    }
    this.array = array;
    size = array.length;
    heapify();
  }

  // 注意：size / 2 - 1 是最后一个叶子
  private void heapify() { // 采用错位相减算出O(n)的那个方案：保留原array + 从尾巴开始percolateDown
    for (int i = size / 2 - 1; i >= 0; i--) {
      percolateDown(i);
    }
  }

  public MinHeap(int cap) {
    if (cap <= 0) {
      throw new IllegalArgumentException("capacity can not be <= 0");
    }
    array = new int[cap];
    size = 0;
  }

  public int size() {
    return size; // size = 最后的index + 1
  }

  public boolean isEmpty() {
    return size == 0; // size是即将加入的位置, size-1是最后一个
  }

  public boolean isFull() {
    return size == array.length; // size是即将加入的位置, size-1是最后一个
  }

  // 要点1：进入循环的条件是index有爹（所以>0）
  private void percolateUp(int index) {
    while (index > 0) {
      int parentIndex = (index - 1) / 2;
      if (array[index] < array[parentIndex]) {
        swap(index, parentIndex);
        index = parentIndex;
      } else {
        break;
      }
    }
  }

  // 要点1： 进入循环的条件是index有孩子（无孩子就直接退出了），即index小于n/2-1
  // 要点2： 由于保证是有了孩子才进来的，所以保证有左孩子。只用检查右孩子
  // 要点3： 在进入下一次loop之前，记得先更新一下自己。
  private void percolateDown(int index) {
    // check if index if legal, last non-leaf node resides in (size/2 -1) 第一个要点
    while (index < size / 2 - 1) {
      // 找后代中最强的
      int leftIndex = index * 2 + 1; // must be valid. 第二个要点，可以不用验证
      int rightIndex = index * 2 + 2;
      int smallerIndex = leftIndex; // initialize (smaller --> prior)
      if (rightIndex < size - 1 && array[rightIndex] < array[leftIndex]) {
        smallerIndex = rightIndex;
      }

      // 然后比较一下最强的和自己如何
      if (array[index] > array[smallerIndex]) {
        swap(index, smallerIndex);
        index = smallerIndex;
        // continue to next level
      } else {
        break;
      }
    }
  }


  public int peek() {
    if (size == 0) {
      throw new NoSuchElementException("heap is already empty");
    }
    return array[0];
  }

  // 要点1：忘记size--了，poll了以后不仅有结构变化，size也应该eagerly computation一下。
  // 要点2：percolateDown之前，要先修改size。
  public int poll() {
    // 国王驾崩后先放个傀儡在慢慢解决矛盾
    if (size == 0) {
      throw new NoSuchElementException("heap is already empty");
    }
    int result = array[0];
    array[0] = array[size - 1]; // size - 1才是最后一个元素，覆盖即可。
    size--; // size先减少，防止percolate的时候把无效值swap上来。
    percolateDown(0);
    return result;
  }

  // 要点1：如果size（下一个要加入的地方）超出了index范围（array.length - 1）那么就扩展，用Arrays.copyOf(src, newsize)
  public void offer(int ele) {
    // 太子升职记 - size是即将加入的位置。
    if (size > array.length - 1) {
      array = Arrays.copyOf(array, (int) (1.5 * array.length));
    }
    array[size] = ele;
    size++; // size先减少。
    percolateUp(size - 1); // size - 1是最后一个元素
  }

  // 要点1：是和原ele比较，而不是和parent、child重新计算是走哪个分支。
  public int update(int index, int ele) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("invalid index");
    }
    int result = array[index]; // 返回原ele
    array[index] = ele;
    if (ele < result) {     // 注意判断进入哪个分支的方法！！！！
      percolateUp(index);
    } else {
      percolateDown(index);
    }
    return result;
  }

  private void swap(int l, int r) {
    int tmp = array[l];
    array[l] = array[r];
    array[r] = tmp;
  }

}
