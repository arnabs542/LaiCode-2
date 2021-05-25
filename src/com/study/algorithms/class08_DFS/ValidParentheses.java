package com.study.algorithms.class08_DFS;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
  // Given n pairs of parentheses, return a list with all the valid permutations.
  //               _
  //              / \
  //            (     x
  //           / \
  //         ((   ()
  //       ...   /  x
  //            ()(
  public List<String> validParentheses(int n) {
    // assumption: n > 0
    List<String> result = new ArrayList<>();
    char[] cur = new char[n * 2]; // buffer
    helper(cur, n, n, 0, result);
    return result;
  }

  // left: how many '(' we still have
  // right: how many ')' we still have
  // index: the current position in cur we want to fill in
  // with either '(' or ')'
  private void helper(char[] cur, int left, int right, int index, List<String> result) {
    // base case:
    //if (left == 0 && right == 0) { // 另一个方案
    if (index == cur.length) {
      result.add(new String(cur));
      return; // NOTICE: 别忘了return
    }
    // recursion rule:
    // case 1: add left parenthesis
    //if (left > 0) { // 如果不用index，那么要这么写。
    cur[index] = '(';
    helper(cur, left - 1, right, index + 1, result);
    //}
    // case 2: add right parenthesis.only when # of ( is larger than # of )
    if (left < right) { // i.e. left < right && right > 0 (后半段没用)
      cur[index] = ')';
      helper(cur, left, right - 1, index + 1, result);
    }
  }
}
