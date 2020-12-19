package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class Reverse {
    // null <- 1 <- 2 <- 3    null
    //        3          prev
    //        2     4         cur
    //              1         next
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return  head;
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
}
