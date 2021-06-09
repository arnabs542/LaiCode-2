package com.study.algorithms.class10_recursion_2.重听;

import com.study.util.ListNode;

public class ReverseListInPairs {
    // cur -> nxt -x> [   ]
    // cur -> subHead
    // nxt -> cur -> subHead
    // return nxt
    public ListNode reverseInPairsR(ListNode head) {
        // base case:
        if (head == null || head.next == null) {
            return head;
        }
        ListNode subHead = reverseInPairsR(head.next.next);
        ListNode nxt = head.next;
        head.next = subHead;
        nxt.next = head;
        return nxt;
    }
    // time: O(n)
    // space: O(n)

    public ListNode reverseInPairs(ListNode head) {
        // iteration 方法，则是顺序搞
        // 重新构造list，不知道head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) { // 后面必须至少还有两个
            ListNode right = cur.next.next;
            ListNode left = cur.next;
            left.next = right.next;
            right.next = left;
            cur.next = right;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
