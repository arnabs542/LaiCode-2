package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        //注意： right 在奇数node情况下更短。


        // find the middle
        // reverse the second part
        // compare each node one by one
        if (head == null || head.next == null) {
            return true;
        }
        // guarantee # of nodes >= 2
        ListNode mid = middleNode(head);
        ListNode right = reverse(mid.next);
        while (right != null) {
            if (right.value != head.value) {
                return false;
            }
            right = right.next;
            head = head.next;
        }
        return true;
    }
    public ListNode middleNode(ListNode head) {
        // 1,2,3
        //   s f (f.next == null)
        // 1,2,3,4
        //   s f (f.next.next == null)
        if (head == null) {
            return head;
        }
        // return the left middle of a even number linkedlist
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode root) {
        // _ 1 2 3
        //       p
        //         c
        //         n

        if (root == null || root.next == null) {
            return root;
        }

        ListNode prev = null;
        ListNode cur = root;
        while (cur != null) { // terminate condition???
            // I want to change the direction of an arrow (2 cur.next = prev)
            // but I don't wanna lose the access of the un-reversed part (1 next = cur.next)
            // I want to move cur, but I don't want to lose the head of the reversed part (3 prev = cur, cur = next)
            ListNode next = cur.next; // 注意，next不需要放在外面。
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
