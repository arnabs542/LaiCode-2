package com.study.algorithms.class04_queue_and_stack;

public class Tester {

  public static void main(String[] args) {
    StackByTwoQueues stack = new StackByTwoQueues();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack.top());
    System.out.println(stack.pop());
    System.out.println(stack.top());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
