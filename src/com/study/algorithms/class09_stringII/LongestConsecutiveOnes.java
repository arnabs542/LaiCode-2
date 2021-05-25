package com.study.algorithms.class09_stringII;

public class LongestConsecutiveOnes {
//  Longest Subarray Contains Only 1s
//  Given an array of integers that contains only 0s and 1s and a positive integer k, you can flip at most k
//          0s to 1s, return the longest subarray that contains only integer 1 after flipping.
//  https://app.laicode.io/app/problem/625
  public int longestConsecutiveOnes(int[] nums, int k) {
    int slow = 0;
    int fast = 0;
    int count = 0;
    int longest = 0;
    while (fast < nums.length) {
      if (nums[fast] == 1) {
        longest = Math.max(longest, ++fast - slow);
      } else if (count < k) {
        count++;
        longest = Math.max(longest, ++fast - slow);
      } else if (nums[slow++] == 0) {
        count--;
      }
    }
    return longest;
  }
}
