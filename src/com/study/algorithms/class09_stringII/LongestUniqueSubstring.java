package com.study.algorithms.class09_stringII;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {
//  Given a string, find the longest substring without any repeating characters and return the length of it.
//  The input string is guaranteed to be not null.
//
//  https://app.laicode.io/app/problem/253

  public int longest(String input) {
    // Assumptions: the input string is not null.
    // the distinct set contains all distinct characters
    // in the sliding window of (slow, fast).
    Set<Character> distinct = new HashSet<>();
    int slow = 0;
    int fast = 0;
    int longest = 0;
    while (fast < input.length()) {
      if (distinct.contains(input.charAt(fast))) {
        // if there is duplicate character, we need to move
        // the slow pointer.
        distinct.remove(input.charAt(slow++));
      } else {
        // if there is no duplicate character, we can slide
        // fast pointer and we have a new sliding window of
        // (slow, fast) containing all distinct characters.
        distinct.add(input.charAt(fast++));
        longest = Math.max(longest, fast - slow);
      }
    }
    return longest;
  }
}
