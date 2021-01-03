package com.study.algorithms.class10_recursion_2;

import com.study.util.ListNode;
import com.study.util.TreeNode;
import com.sun.source.tree.Tree;

public class BinaryTreeUpsideDown {
  // Given a binary tree where all the right nodes are leaf nodes
  // flip it upside down and turn it into a tree with left leaf nodes as the root.
  /*
  Examples
          1 - 5
         /
        2 - 4
       /
      3
  is reversed to
                                                                3
                                                               / \
                                                             2   4
                                                            / \
                                                     left  1   5
  which can be viewed as:
       1
        \
         2 - 5
          \
  left     3 - 4

  subproblem is:
    2
    /\
   3  4
   reverse to
   2  4
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


  // 在recursion方案中，首先会一猛子扎到base case。随后不断地处理掉更多的tree node
  // root可以安心地变成指向null，因为call stack中其他frame存储了各自的root信息。
  // iteration中不可这么安心：
  // 1. subproblem用next来记忆着
  // 2. 本次root要连接的是上一次loop的root和它的right （充当上文lChild的角色）
  //    root
  //     1 - 5
  //    /
  //    2 - 4
  //   /
  //  3
  //

  // -->

  //     1
  //    /
  //    2 - 5
  //   /
  //  3 - 4
  // root
  //
  public TreeNode reverse_iterative(TreeNode root) {
    // iterative way:
    TreeNode prev = null;
    TreeNode prevRight = null;
    TreeNode cur = root;
    // current is also the prevLeft
    while (cur != null) {
      // 1. get the new value
      TreeNode next = cur.left; // left will be the next node to be process
      TreeNode right = cur.right;

      // 3. leave the logic empty initially. add it after 2
      cur.left = prev;
      cur.right = prevRight;

      // 2. update the loop var using new value, and then jump to 3.
      prev = cur;
      cur = next;
      prevRight = right;
    }
    return prev;
  }
}
