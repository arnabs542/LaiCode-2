package com.study.algorithms.class07_hash_table_stringI;

import java.util.*;

// Find the common numbers between two sorted arrays
public class CommonNumbersII {
    // CART:
    // clarification: ascending or descending? duplicate? how large?
    // 需要先沟通清楚：升序降序？有没有重复？两个数组各有多大、大小关系如何？
    // assumptions: 记录clarification中的结论。
    // result: 编写代码
    // test: 过例子

    // assumption:
    //      1. ascending order
    //      2. there could be duplicate numbers in an array
    //      3. 大小关系不确定，可以假设。
    //      4. A & B is not null and not empty

    // Method1: 用hash map练手<value,count>
    // assume a.size < b.size
    //  两边都变成hashmap，避免duplicate的干扰。
    //      step1: insert all numbers in a into a hashset, O(n) in avg, O(n^n) in worst case
    //      step2: insert all numbers in b into a hashset, O(m) in avg, O(m^m) in worst case
    //      step3: for each entry in a, find in b, O(n) in avg, O(n*m) in worst case
    //  Time: O(m+n) in avg, O(m*n) in worst case
    public List<Integer> commonI(int[] a, int[] b) {
        List<Integer> common = new ArrayList<>();
        Map<Integer, Integer> countA = new HashMap<>();
        for (int num : a) {
            countA.put(num, countA.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> countB = new HashMap<>();
        for (int num : b) {
            countB.put(num, countB.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
            Integer cntInB = countB.get(entry.getKey());
            if (cntInB != null) {
                int occurrences = Math.min(entry.getValue(), cntInB);
                for (int i = 0; i < occurrences; i++) {
                    common.add(entry.getKey());
                }
            }
        }
        return common;
    }
    // 这个过不了OJ，因为entrySet它的顺序不是


    // Method2: if a.length ~ b.length 假设规模相近
    // two pointers 谁小移谁，碰到一样的就打印出来
    //  Time: O(max(m,n)) 或 O(n + m)
    //  Extra space: O(1)
    public List<Integer> commonII(int[] a, int[] b) {
        List<Integer> common = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                common.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    // Method3: if a.length << b.length 假设a的规模远小于b
    // O(nlogm), for each a element, run binary search in b

}
