package com.study.algorithms.class04_queue_and_stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackByTwoQueues {
  // implement a stack by using two queues.
  // push(), pop(), top(), isEmpty().
  // when the stack is empty, pop and top return null.

  private Queue<Integer> q1;
  private Queue<Integer> q2;
  //     head    tail
  // q1 [  ]
  // prev = 4
  // current = null --> return 4
  // q2 [ 1 2 3 4]

  //    top
  // s [ 4 3 2 1 ]
  public StackByTwoQueues() {
    q1 = new ArrayDeque<>();
    q2 = new ArrayDeque<>();
  }

  public void push(int x) {
    q1.offer(x);
  }

  public Integer pop() {
    Integer prev = q1.poll();
    Integer cur = q1.poll();
    while (cur != null) { // cur == null, 则prev是第一个了。
      q2.offer(prev);
      prev = cur;
      cur = q1.poll();
    }
    // trick: 直接交换就行了，不用另一个for循环了
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;

    return prev;
  }

  public Integer top() {
    Integer result = this.pop();
    if (result != null) { // trick: top = pop + push if valid。
      this.push(result);
    }
    return result;
  }

  public boolean isEmpty() {
    return top() == null; // trick: 利用top
  }
}
