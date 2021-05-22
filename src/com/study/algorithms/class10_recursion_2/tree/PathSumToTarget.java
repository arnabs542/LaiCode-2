package com.study.algorithms.class10_recursion_2.tree;

import com.study.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumToTarget {
//        Binary Tree Path Sum To Target (the path can only be from one node to
//        itself or to any of its descendants)
//        Given a binary tree in which each node contains an integer number. Determine if there exists a path
//        (the path can only be from one node to itself or to any of its descendants), the sum of the numbers
//        on the path is the given target number.
//        https://app.laicode.io/app/problem/141

  public boolean exist(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    // pass down the prefix of the path.
    List<TreeNode> path = new ArrayList<TreeNode>();
    return helper(root, path, sum);
  }

  private boolean helper(TreeNode root, List<TreeNode> path, int sum) {
    path.add(root); // 吃
    // check if can find a subpath ended at root node,
    // the sum of the subpath is target.
    int tmp = 0;
    for (int i = path.size() - 1; i >= 0; i--) {
      tmp += path.get(i).key;
      if (tmp == sum) {
        return true;
      }
    }
    if (root.left != null && helper(root.left, path, sum)) {
      return true;
    }
    if (root.right != null && helper(root.right, path, sum)) {
      return true;
    }
    // don't forget for the cleanup when return to the previous level.
    path.remove(path.size() - 1); // 吐
    return false;
  }

}
