package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class AddNodeIntoSortedLinkedList {
    public ListNode addNode(ListNode head, int target) {
        // return new head.

        ListNode tar = new ListNode(target);
        // three cases:
        // 1
        if (head == null || target <= head.value) {
            tar.next = head;
            return tar;
        }

        // 2
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.value < target && target <= cur.next.value) { // N个9的情况，插前是O(1)，插后是O(n)
                tar.next = cur.next;
                cur.next = tar;
                return head;
            }
            cur = cur.next;
        }

        // 3 (cur.next == null) && (target > cur.next.value)  这个也可以包括到上面的, 它和if里面的行为一样。
        cur.next = tar;
        return head;
    }


    // 把case3合并到case2
    public ListNode addNode2(ListNode head, int target) {
        // return new head.

        ListNode tar = new ListNode(target);
        // three cases:
        // 1
        if (head == null || target <= head.value) {
            tar.next = head;
            return tar;
        }

        // 2
        ListNode cur = head;
        while (cur != null) { // 为了合并这俩，那么cur.next == null的情况要包括进来了
            if (cur.next == null || cur.value < target && cur.next.value >= target) { // case 3 || case 2。不可以写反，写反了NPE
                tar.next = cur.next;
                cur.next = tar;
                return head;
            }
            cur = cur.next;
        }
        return head; // 意外情况，不应该走到这里
    }
}