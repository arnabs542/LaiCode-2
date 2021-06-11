package com.study.algorithms.class11_DP_1.重听;

public class LongestAscendingSubArray {
    // linear scan (input or M), look back (previous M element)

    // 三个内容：物理意义，base rule，induction rule
    // M[i] represents [within 0 ... i] the max length of ascending subarray that includes A[i]
    //     即 cur的含义是，在[0,i]中，包括[i]在内的那个asc subarray的长度
    // base rule:       第一个位置是1 （每次写入的必须是正确的，所以不能一下子把所有的都写成1）
    // induction rule:  往后每个位置的数字，如果比前一个大，则 M[i] = M[i-1] + 1, else M[i] = 1
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int cur = 1;
        int globalMax = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur += 1;
                globalMax = Math.max(cur, globalMax);
            } else {
                cur = 1;
            }
        }
        return globalMax;
    }
    // Time: O(n)
    // Space: O(1)
}
