package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class ReversePair {
    public ListNode reverse(ListNode head) {
        // input head
        // get the reversed sublist head
        // return the reversed new head

        // base case
        if (head == null || head.next == null) {
            return head;
        }

        // recursive rule:
        // n1->n2->subHead (不要写n3)

        //     n2       -- new head
        //   </
        // n1  ->  subHead
        ListNode next = head.next;
        head.next = reverse(head.next.next);
        next.next = head;
        return next;
    }
}
