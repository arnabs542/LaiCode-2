package com.study.algorithms.class10_recursion_2.tree;

import com.study.util.TreeNode;

public class MaxPathSumNodeToDescendant {
  public int maxPathSum(TreeNode root) {
    int[] globalMax = new int[1];
    globalMax[0] = Integer.MIN_VALUE;
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
    int left = Math.max(0, maxPathSum(root.left, globalMax));
    int right = Math.max(0, maxPathSum(root.right, globalMax));
    // compute the maxSumPath of current layer ( one path, no "八" path)
    int max = Math.max(left, right) + root.key;
    globalMax[0] = Math.max(max, globalMax[0]);
    // return the max single path from root
    return max;
  }
}
