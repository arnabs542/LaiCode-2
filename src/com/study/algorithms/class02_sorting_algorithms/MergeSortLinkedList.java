package com.study.algorithms.class02_sorting_algorithms;

import com.study.util.ListNode;

public class MergeSortLinkedList {
  // 3 -> | 2 <- 1, is sorted to 1 -> 2 -> 3 -> null
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // split the linked list into two halves
    ListNode middle = findMiddle(head);
    ListNode first = head;
    ListNode second = middle.next;
    middle.next = null;
    // sort each half
    second = reverse(second);
    first = mergeSort(first);
    second = mergeSort(second);
    // combine two halves
    // 谁小移谁
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (first != null && second != null) {
      if (first.value < second.value) {
        cur.next = first;
        cur = cur.next;
        first = first.next;
      } else {
        cur.next = second;
        cur = cur.next;
        second = second.next;
      }
    }
    if (first == null) {
      cur.next = second;
    } else {
      cur.next = first;
    }
    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
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

  private ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    // a b c d e g
    //     s
    //         f
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // Time: O(1.5 * # of list nodes) ==> O(n) where n is the # of input nodes
}
