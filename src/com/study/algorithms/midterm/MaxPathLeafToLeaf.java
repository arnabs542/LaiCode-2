package com.study.algorithms.midterm;

import com.study.util.TreeNode;

// Given a binary tree in which each node contains an int number.
// Find the maximum possible sum from any leaf node to another leaf node.
// The maximum sum path may or may not go through root.
// Expected time complexity is O(n).
public class MaxPathLeafToLeaf {
  // CA:
  // Assumption:
  // 1. class TreeNode {int key; TreeNode left; TreeNode right}
  // 2. input: is a root node;  output: is the int sum
  // 3. if we cannot find the path, return Integer.MAX_VALUE
  //      root
  //      /  \
  //    null  null

  //      root
  //      /  \
  //    null  right

  //      root
  //      /  \
  //    left  null

  // Solution:
  // DFS:
  // base case: reach the leaf(null), return 0
  // recursive rule:
  //    from child: get the max sum of values in the path from one child to a leaf.
  //    what I do: if it is a valid situation, try to update globalMax. 与下一步的valid情况合并。
  //    what I return:
  //            if both children are not null: max(children results) + my.key,     并且在这里做update globalMax。
  //            if one of children is null: return (the other one) + my.key
  //            if both are null: my.key

  public int maxPath(TreeNode root) {
    // sanity check
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    int[] globalMax = new int[]{Integer.MIN_VALUE};
    helper(globalMax, root);
    return globalMax[0];
  }

  private int helper(int[] globalMax, TreeNode root) {
    // base case:
    if (root == null) {
      return 0;
    }
    int left = helper(globalMax, root.left);
    int right = helper(globalMax, root.right);
    if (root.left == null && root.right == null) {
      return root.key;
    } else if (root.left == null) {
      return right + root.key;
    } else if (root.right == null) {
      return left + root.key;
    } else {
      globalMax[0] = Math.max(globalMax[0], left + right + root.key);
      return Math.max(left, right) + root.key;
    }
  }
}
