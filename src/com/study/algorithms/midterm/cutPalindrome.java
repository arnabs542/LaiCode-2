package com.study.algorithms.midterm;
// Given a string, a partitioning of the string is a palindrome partitioning if every partition is a palindrome.
// For example, “aba |b | bbabb |a| b| aba” is a palindrome partitioning of “ababbbabbababa”.
// Determine the fewest cuts needed for palindrome partitioning of a given string.

// For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”.
// If a string is palindrome, then minimum 0 cuts are needed.
// Return the minimum cuts.

public class cutPalindrome {
  // Assumption:
  // input: a string, not null.
  // output: int
  // corner case: for an empty string, return -1

  // DP:
  // dp[i] represents: for first i letters, how many cuts we need to cut it into palindrome.
  // base rule: dp[0] = 0; dp[1] = 0;
  // induction rule: dp[i] = 0,  if first i letters is a palindrome;
  //                 MIN({dp[j]|0 < j < i}) + 1, if right part [j,i) is a palindrome
  //                  different rightmost cut positions:
  //
  //
  //

  public int minCuts(String s) {
    // corner case:
    if (s.length() == 0) {
      return 0;
    }

    int[] dp = new int[s.length() + 1];
    // base case
    dp[0] = 0;
    dp[1] = 0;
    // induction rule:
    for (int i = 2; i <= s.length(); i++) {
      // case 1:
      if (isPalindrome(s, 0, i - 1)) {
        dp[i] = 0;
        continue;
      }
      // case 2:
      dp[i] = Integer.MAX_VALUE;
      for (int j = 1; j < i; j++) {
        if (isPalindrome(s, j, i - 1)) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }
    return dp[s.length()];
  }


  private boolean isPalindrome(String s, int left, int right) {
    int i = left;
    int j = right;
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}


