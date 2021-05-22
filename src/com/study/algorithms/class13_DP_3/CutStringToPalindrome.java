package com.study.algorithms.class13_DP_3;

public class CutStringToPalindrome {
  // input: String input
  // output: int count

  // Assumption:
  // 1. if input is null -- return 0
  // 2. if input empty or has one element -- return 0
  // 3. if we cannot palindrome partition input -- return -1   case3的时候，填入-1.

  // DP:
  // M[i] represents the fewest cuts to palindrome partition the first i letters.
  // M[i]表达的是切前i个字母为回文区间的最小切割次数

  // base rule:
  // M[0] = 0, M[1] = 0.  (M[0]可以写-1）

  // induction rule:
  // M[i] = 0, 条件：[0,i] is palindrome     case 1
  //      = MIN({M[j]| 0<j<i &&  }) + 1, 条件：右小段[j,i) is palindrome    (j是左大段字母数量)    case 2
  //      = -1, 条件：不满足前两个条件   case 3

  // Complexity:

  public int minCuts(String input) {
    // sanity check
    if (input == null || input.length() == 0) {
      return 0;
    }

    int[] M = new int[input.length() + 1];
    // base rule:
    M[0] = 0;
    M[1] = 0;
    // induction rule:
    for (int i = 2; i <= input.length(); i++) {
      // i represents first i letters, e.g. charAt(i-1) is this letter.
      int minCut = Integer.MAX_VALUE;
      // case 1: is Palindrome
      if (isPalindrome(input, 0, i - 1)) {
        M[i] = 0;
        continue;
      }
      // case 2: try to cut in different position
      for (int j = 1; j < i; j++) {
        // j represents how many letters in "left part"
        // [0, j) left part, has j letters
        // [j, i) right part, has i-j letters.
        // 右小段是palindrome，才有资格在M里看左大段
        if (isPalindrome(input, j, i - 1)) {
          minCut = Math.min(M[j] + 1, minCut);
        }
      }
      // case 2 fill in & case 3: failed
      M[i] = (minCut == Integer.MAX_VALUE) ? -1 : minCut; // 如果是约定不能切就返回max，那么就直接赋值minCut即可。
    }
    return M[input.length()];
  }

  private boolean isPalindrome(String input, int left, int right) {
    // [left, right] included range
    if (left >= right) { // one letter
      return true;
    }
    while (left < right) {
      if (input.charAt(left) != input.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

}
