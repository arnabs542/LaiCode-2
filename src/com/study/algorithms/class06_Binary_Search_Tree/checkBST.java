package com.study.algorithms.class06_Binary_Search_Tree;

import com.study.util.TreeNode;

public class checkBST {
  public boolean isBST(TreeNode root) {
    return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }

  private boolean isBST(TreeNode root, int max, int min) {
    if (root == null) {
      return true;
    }
    if (root.key >= max || root.key <= min) { //NOTICE: 闭区间。
      return false;
    }
    return isBST(root.left, root.key, min) && isBST(root.right, max, root.key);
  }
}
