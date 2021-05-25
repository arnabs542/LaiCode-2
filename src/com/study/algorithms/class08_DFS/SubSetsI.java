package com.study.algorithms.class08_DFS;

import java.util.ArrayList;
import java.util.List;

public class SubSetsI {
  //      {}
  //   {a} {}
  //{ab} {a} {b} {}
  //
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<>();
    // sanity check
    if (set == null) {
      return result;
    }
    char[] input = set.toCharArray(); // 本题，没有必要用CharArray, 调用.charAt就行，因为是read only。不需要swap啥的。
    // record the current subset by prefix
    StringBuilder prefix = new StringBuilder();
    helper(input, 0, prefix, result);
    return result;
  }

  // at each level, determine the character at the position "index"
  // to be picked or not
  private void helper(char[] input, int index, StringBuilder prefix, List<String> result) {
    // base case:
    // after deciding pick or not each character
    // we have a complete subset
    if (index == input.length) {
      result.add(prefix.toString());
      return;
    }
    // recursion rule:
    // case 1: pick the char at index
    prefix.append(input[index]);
    helper(input, index + 1, prefix, result);
    prefix.deleteCharAt(prefix.length() - 1); //remove the last one(not the index-th)

    // case 2: do not
    helper(input, index + 1, prefix, result);
  }
  // time:  O(2^n*n)
  // space: O(2^n*n),  如果不算输出则O(n) 是recursion tree的height（粉色路径）

}
