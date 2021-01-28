package com.study.practice.data_structure;
// Array实现Deque
public class MyCircularQueue {
  // 第一个挑战，需要ring buffer --> head = (head + 1) % array.length
  // 第二个挑战，需要知道何时空，何时满（因为head==tail可能表达空或者满）
  // _ 1 _ _ _ _ _ _
  // h
  //     t
  // head: 第一个元素
  // tail: 即将插入的位置:next available position

  private int[] array;
  private int head = 0;
  private int tail = 1;
  /** Initialize your data structure here. Set the size of the queue to be k. */
  public MyCircularQueue(int k) {
    if (k < 1) {
      throw new IllegalArgumentException("Illegal capacity");
    }
    array = new int[k + 1]; // 存放k个元素，我的方法要k+1个格子
  }
  public MyCircularQueue() {
    this(16);
  }

  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
    if (tail == head) {
      return false;
    }
    array[tail] = value;
    tail = (tail + 1) % array.length;
    return true;
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
    if (head + 1 == tail) {
      return false;
    }
    head = (head + 1) % array.length;
    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    if (head + 1 == tail) {
      return -1; // assumption
    }
    int headIndex = (head + 1) % array.length;
    return array[headIndex]; // notice
  }

  /** Get the last item from the queue. */
  public int Rear() {
    if (head + 1 == tail) {
      return -1;
    }
    int rearIndex = (tail - 1 + array.length) % array.length;
    return array[rearIndex];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
    return (head + 1) % array.length == tail;
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
    return head == tail;
  }

}
