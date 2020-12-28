package com.study.algorithms.class12_DP_2;

public class LargestSubarraySum {
    // input: 1,2,4,-1,-2,-10,1
    // sum:   1,3,7, 6, 4, -6,1
    // base rule: sum[0] = input[0]
    // induction rule:
    //     sum[i] = sum[i-1] + input[i], if sum[i-1] > 0
    //     sum[i] = input[i]           , else

    public int largestSum(int[] input) {
        // assume input is not null and not empty

        // base rule:
        int sum = input[0];
        int maxSum = input[0];
        // induction rule:
        for (int i = 1; i < input.length; i++) {
            // i represents the i-th element in the input array,
            sum = Math.max(sum + input[i], input[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
