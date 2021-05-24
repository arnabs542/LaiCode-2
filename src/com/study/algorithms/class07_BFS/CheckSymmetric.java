package com.study.algorithms.class07_BFS;

import com.study.util.TreeNode;

public class CheckSymmetric {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode one, TreeNode two) {
    // 自己要是不相等，直接返回。
    // ！！但是判断相等（dereference）前要看是不是null
    if (one == null && two == null) {
      return true;
    } else if (one == null || two == null) {
      return false;
    } else if (one.key != two.key) {
      return false;
    }
    return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
  }
}
