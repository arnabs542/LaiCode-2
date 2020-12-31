package com.study.algorithms.class03_linkedlist;

import com.study.util.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
    // 注意1： 忘记移动l1 和 l2了，导致了Timeout
    // 注意2： 忘记为两个数字一样长，但是有最高位carry的情况新建分支。（post-proccessing）
    // 注意3： 本题目直接就是reverse的给我，所以看情况，是否需要先reverse两个list
    // 注意4： val的情况可以合并，后处理也可以合并。
    //          修改while循环的停止条件，
    //        l1和l2都非空，可以让while里面简单
    //        l1, l2 或 carry非空，然后在while里面判断哪个非空。统一采用一个value来累加。是更合理的。

    // 1. 看情况，是否需要先reverse两个list
    // 2. 从head开始，相加，并且记录进位。
    // 3. 创建新的list返回
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null && l2 != null) {
      int value = l1.value + l2.value + carry;
      carry = value / 10;
      value = value % 10;
      cur.next = new ListNode(value);
      l1 = l1.next;
      l2 = l2.next;
      cur = cur.next;
    }
    if (l1 == null && l2 == null) {
      cur.next = new ListNode(carry);
      carry = 0;
    } else if (l1 == null) {
      while (l2 != null) {
        cur.next = new ListNode(l2.value + carry);
        l2 = l2.next;
        carry = 0;
      }
    } else {
      while (l1 != null) {
        cur.next = new ListNode(l1.value + carry);
        l1 = l1.next;
        carry = 0;
      }
    }
    return dummy.next;
  }

  public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int value = 0;
      if (l1 != null) {
        value += l1.value;
        l1 = l1.next;
      }
      if (l2 != null) {
        value += l2.value;
        l2 = l2.next;
      }
      if (carry != 0) {
        value += carry;
        carry = 0; // to be more reasonable
      }

      carry = value / 10;
      value = value % 10;

      cur.next = new ListNode(value);
      cur = cur.next; // 又忘记移动了
    }
    return dummy.next;
  }
}
