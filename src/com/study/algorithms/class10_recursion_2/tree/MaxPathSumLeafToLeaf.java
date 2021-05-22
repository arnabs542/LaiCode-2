package com.study.algorithms.class10_recursion_2.tree;

import com.study.util.TreeNode;

public class MaxPathSumLeafToLeaf {
  // So the solution consisits two part: leaf to a turnning node, turnning node to another leaf.
// Assumption:
// 1. root is not null
// 2. input a root, output the sum
// 3. Class TreeNode {int key; TreeNode left; TreeNode right}
// https://app.laicode.io/app/problem/138

// Method: Recursion
/*
            m(5)            -- omit m() funciton call in this tree
           1     2
        3   -1  #  12
      #  #  # #     # #

      each node:
      1. expect the maxPathSum from left and right child
      2. update the globalMax using (left + right + root.key)
      3. return the max(left, right) + root.key

*/


// Time:

  public int maxPathSum(TreeNode root) {
    int[] globalMax = new int[1];
    globalMax[0] = Integer.MIN_VALUE;
    maxPathSum(root, globalMax);
    return globalMax[0];
  }

  private int maxPathSum(TreeNode root, int[] globalMax) {
    // base case:
    if (root == null) {
      return 0;
    }

    // recursion rule:
    // 1. get the left, right single path value
    int left = maxPathSum(root.left, globalMax);
    int right = maxPathSum(root.right, globalMax);
    // 2. update if possible
    // 常见错误2，如果左右孩子中有null，那么这个值是invalid的，不可以去更新。
    if (root.left != null && root.right != null) { // 这才是一个valid的case。
      int sum = left + right + root.key;
      globalMax[0] = Math.max(sum, globalMax[0]);
    }

    // 3. return the max single path
    // 常见错误3，因为孩子的返回值可能是负数，
    //  如果root的孩子是一负数、一个null
    //  那么返回的是 负数 和 0
    //  这个时候就不能求max了，要讨论一下。
    // -- return Math.max(left, right) + root.key;
    if (root.left == null && root.right == null) {
      return root.key;
    } else if (root.left == null) {
      return root.key + right;
    } else if (root.right == null) {
      return root.key + left;
    } else {
      // 这里才能安心求max
      return Math.max(left, right) + root.key;
    }
  }
}
