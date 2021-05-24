package com.study.algorithms.class07_BFS;

import com.study.util.TreeNode;

public class CheckBalanced {

  //     root
  //     /  \
  //    a    b
  // height diff or return false
  public boolean isBalanced(TreeNode root) {
    // sanity check:
    if (root == null) {
      return true;
    }
    return height(root) != -1;
  }

  private int height(TreeNode root) {
    // base case:
    if (root == null) {
      return 0;
    }
    int leftH = height(root.left);
    if (leftH == -1) {
      return -1;
    }
    int rightH = height(root.right); // 问题1.应当在leftH计算完毕后直接判断，而不是跑去计算right。这样可以early return
    if (rightH == -1) {
      return -1;
    }

    if (Math.abs(leftH - rightH) > 1) {
      return -1;
    } else {
      return Math.max(leftH, rightH) + 1;
    }
  }
  // time complexity:
  // time complexity: O(n)
}
