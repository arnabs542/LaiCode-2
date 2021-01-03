package com.study.algorithms.class10_recursion_2.linkedlist;
import com.study.util.ListNode;

// Reverse pairs of elements in a singly-linked list.

/*
let's define the sub-problem:
before:
  head
  node1 -> node2 -> | ... |
  cur       next
after:
  node2 -> node1 -> | ... |
* */

// base case: null, or only one node.
// recursive rule:
//    cur.next = newHead
//    next.next = cur
//    return next
public class ReverseListInPairs {

  // recursive way
  // time: O(n)
  // extra space: O(n) in recursion tree
  public ListNode reverseInPairs(ListNode head) {
    // base case: null or single node
    if (head == null || head.next == null) {
      return head;
    }
    // recursive rule:
    ListNode newHead = reverseInPairs(head.next.next);
    ListNode next = head.next;
    head.next = newHead;
    next.next = head;
    return next;
  }

  // Here is also an iterative solution
  // time: O(n)
  // extra space: O(1)
  public ListNode reverseInPairs_iterative(ListNode head) {
    // we create / adjust the head, so we need a dummy to simplify it
    // _ -> 1 -> 2 -> 3 -> ...
    // d
    // c
    //          n
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
                                     // 与recursion方法的对照：
      ListNode next = cur.next.next; // next = head.next
      cur.next.next = next.next;     // head.next = newHead (1->3)
      next.next = cur.next;          // next.next = head (2->1)
      cur.next = next;               // return next (dummy->2)
      cur = cur.next.next;           // pop from stack
    }
    return dummy.next;
  }
}
