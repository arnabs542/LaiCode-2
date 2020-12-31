package com.study.practice.data_structure;

import com.study.util.ListNode;

// offer, poll, peek
// return null when queue is empty
public class MyQueue {
  private ListNode head; // 从head删比较好，因为它容易找到下一个节点。tail不能O(1)找上一个节点。
  private ListNode tail;

  public void offer(int value) {
    ListNode node = new ListNode(value);
    if (head == null && tail == null) { // first time or empty
      head = node;
      tail = node;
    } else {            // not empty
      tail.next = node;
      tail = tail.next;
    }
  }

  public Integer poll() {
    if (head == null) {
      return null;
    }
    ListNode prev = head;
    head = head.next;
    if (head == null) { // 为空时update tail, 不update算法可行、逻辑不好。
      tail = null;
    }
    prev.next = null; // best practice
    return prev.value;
  }

  public Integer peek() {
    if (head == null) {
      return null;
    }
    return head.value;
  }
}
