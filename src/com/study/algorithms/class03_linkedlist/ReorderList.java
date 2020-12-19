package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class ReorderList {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. find the middle node
        ListNode mid = middleNode(head);
        // de-link the second half from the list
        ListNode one = head;
        ListNode two = mid.next;
        mid.next = null; // de-link

        // 2. reverse the second half
        two = reverse(two);
        // 3. merge the two halves
        return merge(one, two);
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
    public ListNode merge(ListNode one, ListNode two) {
        if (one == null) {
            return two;
        } else if (two == null) {
            return one;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            // 注意，本题的merge是一个一个插入，不是谁小移谁。
            cur.next = one;
            one = one.next;
            cur = cur.next;

            cur.next = two;
            two = two.next;
            cur = cur.next;
        }
        // post
        if (one == null) {
            cur.next = two;
        } else {
            cur.next = one;
        }
        return dummy.next;
    }
}
