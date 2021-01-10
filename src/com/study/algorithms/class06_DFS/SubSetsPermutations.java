package com.study.algorithms.class06_DFS;

import java.util.ArrayList;
import java.util.List;

public class SubSetsPermutations {
  // 考虑先后顺序的区别
  public List<String> allPermutationsOfSubsets(String set) {
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    helper(array, 0, result);
    return result;
  }

  private void helper(char[] array, int index, List<String> result) {
    // all nodes in the recursion tree contians a valid result
    result.add(new String(array, 0, index));
    for (int i = index; i < array.length; i++) {
      swap(array, i, index);
      helper(array, index + 1, result);
      swap(array, i, index);
    }
  }

  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
