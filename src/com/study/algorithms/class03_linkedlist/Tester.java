package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class Tester {
    public static void main(String args[]) {
        com.study.util.ListNode head = new com.study.util.ListNode(0);
        com.study.util.ListNode cur = head;
        for(int i = 1; i < 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        ReversePair reversePair = new ReversePair();
        head = reversePair.reverse(head);
        System.out.println(head);
    }
}
