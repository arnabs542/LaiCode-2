package com.study.algorithms.class10_recursion_2.linkedlist;

import com.study.util.ListNode;

public class ReverseList {
  public ListNode reverse(ListNode head) {
    // base case:
    if (head == null || head.next == null) {
      return head;
    }
    // recursion rule:
    ListNode subHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return subHead;
  }
}
