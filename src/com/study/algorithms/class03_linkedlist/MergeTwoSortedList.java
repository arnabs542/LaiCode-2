package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class MergeTwoSortedList {
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
