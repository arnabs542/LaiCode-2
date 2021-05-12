package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class MergeTwoSortedList {
  // 春季3 新
  public ListNode merge2(ListNode head1, ListNode head2) {
    // 什么时候用Dummy Head? --> When you want to build a linkedlist from scratch.(从零开始建一个链表) 为了方便就声明一个
    // 什么时候需要维护一个Tail pointer？ --> 当你要在tail不断接入新的元素的时候

  }



  public ListNode merge(ListNode head1, ListNode head2) {
    // sanity check:
    if (head1 == null) {
      return head2;
    } else if (head2 == null) {
      return head1;
    }

    // since head may change, we use a dummy node.
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (head1 != null && head2 != null) {
      if (head1.value < head2.value) {
        cur.next = head1;
        head1 = head1.next;
      } else {
        cur.next = head2;
        head2 = head2.next;
      }
      cur = cur.next;
    }
    // post
    if (head1 == null) {
      cur.next = head2;
    } else {
      cur.next = head1;
    }
    return dummy.next;
  }
}


