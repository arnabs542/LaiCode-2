package com.study.algorithms.class07_Heap;

public class Q1_Find_Smallest_K_elements {
    // Solution 1: 一个maxHeap
    // 每个人和maxHeap的max值比较，如果比它还低，就代替掉这个max
    // time: O(n)
    // space: O(k)

    // Solution 2: Quick Select
    // 把小的丢到pivot的左边，大的放右边。  此时pivot的位置肯定是对的，看pivot是不是小于等于k了。
    // average time: O(n + n/2 + n/4 + ... k) = O(n)
    // worst case: O(n^2)
    // space: O(n)



}
