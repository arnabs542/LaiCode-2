package com.study.practice.data_structure;

import com.study.util.ListNode;

public class MyStack {
  // 1. 一开始和面试官define好各个API的特别情况（比如是throw exception 还是 null）
  //    return null的话，不能是primitive type，要用Integer。
  private ListNode head;

  // push()
  public void push(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = head; // add at head, so O(1)
    head = newNode;
  }

  // pop()
  public Integer pop() {
    if (head == null) {
      return null;  // Integer作为返回值就可以return null
    }
    ListNode prev = head; // Best practice - 不希望这个还连着
    head = head.next;
    prev.next = null; // best practice
    return prev.value;
  }

  // peek()
  public Integer peek() {
    if (head == null) {
      return null;
    }
    return head.value;
  }
}
