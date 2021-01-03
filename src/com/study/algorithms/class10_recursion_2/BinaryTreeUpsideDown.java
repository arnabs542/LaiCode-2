package com.study.algorithms.class10_recursion_2;

import com.study.util.ListNode;
import com.study.util.TreeNode;

public class BinaryTreeUpsideDown {
  // Given a binary tree where all the right nodes are leaf nodes
  // flip it upside down and turn it into a tree with left leaf nodes as the root.
  /*
  Examples
          1
         / \
        2   5
       / \
      3   4
  is reversed to
            3
           / \
         2   4
        / \
 left  1   5
  which can be viewed as:
       5   1   left
        \ /
         4   2
          \ /
           3

  subproblem is:
    2
    /\
   3  4
   reverse to
   4  2
    \/
    3

  * */

  // 什么时候来获得newRoot？
  // 应该在root.left修改前获得即可。

  public TreeNode reverse(TreeNode root) {
    // base case:
    if (root == null || root.left == null) {
      return root;
    }
    // get the new root from sub-problem
    TreeNode newRoot = reverse(root.left);
    // remember the lChild and rChild child
    TreeNode lChild = root.left;
    TreeNode rChild = root.right;
    // put rChild child to new position
    lChild.left = root;
    root.left = null;
    root.right = null;
    // put root to new position
    lChild.right = rChild;
    // return the root of sub-problem as my root
    return newRoot;
  }
}
