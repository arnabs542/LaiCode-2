package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class FindMiddle {
    public ListNode findMiddle (ListNode head) {
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
