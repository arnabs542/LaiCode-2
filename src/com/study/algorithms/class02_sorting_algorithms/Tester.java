package com.study.algorithms.class02_sorting_algorithms;

import java.util.Arrays;

import com.study.util.ListNode;

public class Tester {
  public static void main(String[] args) {
    MoveZeroI mz = new MoveZeroI();
    int[] result = mz.moveZero(new int[]{1, 0, 5, 7, 0, 3, 0, 2});
    System.out.println(Arrays.toString(result));

    int[] unsortedArray = new int[]{3, 5, 1, 2, 4, 8};

    MergeSortII mergeSortII = new MergeSortII();
    mergeSortII.mergeSort(unsortedArray);
    System.out.println(Arrays.toString(unsortedArray));

    MergeSortLinkedList mergeSort = new MergeSortLinkedList();
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);

    System.out.println(mergeSort.mergeSort(head));
  }
}
