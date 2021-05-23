package com.study.practice.class07_graph_binary_tree_I.BST;

import com.study.util.TreeNode;

public class Search {
  // recursion --> interation
  // 一般是要模拟一个call stack，但是如果是tail recursion就不需要
  // 因为tail recursion不需要用到那些存储下来的东西。
  // 面试的时候，如果是tail recursion，一般是要优化的。 （要去观察一下）

  // 1. Search in a BST:
  // recursion方案
  // 这是一个 tail recursion --> recursive call 永远是return前的最后一个execution，
  //                            即递归回来的时候，不不要stack中的任何data。
  public TreeNode search(TreeNode root, int target) {
    // 1. process root
    if (root == null || root.key == target) {
      return null;
    }
    // 2. check left node, if target less than root.key
    if (root.key > target) {
      return search(root.left, target); // -- beark point
    }
    // 3. check right node
    else {
      return search(root.right, target);
    }
  }

  // iteration
  // 所有的tail recursion 都可以easily transfer to iterative solution.
  public TreeNode search2(TreeNode root, int target) {
    while (root != null && root.key != target) { // 对base case取反
      if (target < root.key) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return root;
  }
}
