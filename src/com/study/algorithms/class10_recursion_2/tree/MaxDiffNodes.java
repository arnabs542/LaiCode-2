package com.study.algorithms.class10_recursion_2.tree;

import com.study.util.TreeNode;

public class MaxDiffNodes {
  public int maxDiffNodes(TreeNode root) {
    int[] globalMax = new int[1];
    globalMax[0] = Integer.MIN_VALUE;
    maxDiffNodes(root, globalMax);
    return globalMax[0];
  }
  // what I expect to know from my children:
  // what is the total number of this subtree:
  // (1) # of nodes in my left subtree
  // (2) # of nodes in my right subtree

  // what I want to do in my layer
  // abs((1) - (2)) is the diff of current layer.
  // update global max or not

  // what I need to return
  // (1) + (2) + 1
  private int maxDiffNodes(TreeNode root, int[] globalMax) {
    // base case:
    if (root == null) {
      return 0;
    }
    // get the # of nodes in subtree
    int leftTotal = maxDiffNodes(root.left, globalMax);
    int rightTotal = maxDiffNodes(root.right, globalMax);
    // update the gloablMax or not
    globalMax[0] = Math.max(Math.abs(leftTotal - rightTotal), globalMax[0]);
    // return # of my tree ndoes
    return leftTotal + rightTotal + 1;
  }
}
