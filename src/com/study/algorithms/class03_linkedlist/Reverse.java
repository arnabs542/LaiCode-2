package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class Reverse {
  // null <- 1 <- 2 <- 3    null
  //        3          prev
  //        2     4         cur
  //              1         next
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  // Iterative way
  public ListNode reverseLinkedListIteratively(ListNode head) {
    // corner case:
    if (head == null || head.next == null) {
      return head;
    }
    //         n1  ->  n2   ->   null
    //    p     c      n
    //
    //
    // null <-  n1    n2 -> null
    //         p       c      n
    //
    // null <-  n1 <-  n2  null
    //                 p     c      n 不能取
    //
    // return p

    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  // Recursive way
  // 虚线框框住sub problem，返回值是newHead了
  // 子问题期待：newHead，全部翻转。 (而且我head.next的next应该是指向null了)  <-- aha moment
  // 当前层解决：cur.next.next = cur, 然后返回newHead

  // 每次把这个"子问题"解决好，所以head.next = null.
  // 这样：如果还有更大规模的问题，head.next.next会从null变成head
  //
  public ListNode reverseLinkedListRecursively(ListNode head) {
    if (head == null || head.next == null) { // base case
      return head;
    }
    ListNode newHead = reverseLinkedListRecursively(head.next); // 解决虚线框里的子问题
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
