package com.study.algorithms.class10_recursion_2.tree;

import com.study.util.TreeNode;

public class MaxPathSum {
  // Given a binary tree in which each node contains an integer number.
  // Find the maximum possible sum
  // from any node to any node -- the start and end can be same

  // Assumption: the root is not null
  // Input: root
  // Output: max sum

  // 3 steps to analyze it:
  // 1. What do I expect from my children?
  // (1) is max(0, left),  left: max single path end at leftChild - “八”字的“丿”
  // (2) is max(0, right), right: max single path end at rightChild - “八”字的“㇏”
  //

  // 2. What I will do in my layer?
  // (1) + (2) + root.key ==> MaxPathSum in my layer.
  // update the globalMax if necessary.

  // 3. What I will report to my parent?
  // report Math.max((1),(2)) + root.key ==> max single path end at me.


  public int maxPathSum(TreeNode root) {
    int[] globalMax = new int[1];
    maxPathSum(root, globalMax);
    return globalMax[0];
  }

  public int maxPathSum(TreeNode root, int[] globalMax) {
    // base case:
    if (root == null) {
      return 0;
    }
    // recursion rule:
    // get the max single path from left / right child
    int left = Math.max(0, maxPathSum(root.left));
    int right = Math.max(0, maxPathSum(root.right));
    // compute the maxSumPath of current layer
    globalMax[0] = Math.max((left + right + root.key), globalMax[0]);
    // return the max single path from root
    return Math.max(left, right) + root.key;
  }
}
