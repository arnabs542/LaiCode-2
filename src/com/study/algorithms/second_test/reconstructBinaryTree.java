package com.study.algorithms.second_test;

import com.study.util.TreeNode;

import java.util.Map;

public class reconstructBinaryTree {
  // preorder:  1 2 3
  //   meaning: to determine the root
  // inorder:   2 1 3
  //   meaning: to determine the subtrees of root

  // example:   input: 1 2 3, 2 1 3
  //                   pl pr  il  ir
  //         then: root is 1,
  //         left subtree is 2     -->   store the 2 into hashMap
  //         right subtree is 3
  // then: call construct(2,2) and construct(3,3)

  // idxMap maps each node in the in-order array to its index in in-order array. --> help determine leftSize
  // Recursion function returns the sub-tree root.

  // Time = O(n)
  // Space = O(n)
  public TreeNode construct(int[] in, int il, int ir, int[] pre, int pl, int pr, Map<Integer, Integer> idxMap){
    // base case:
    if (il > ir) {
      return null;
    }

    // rule:
    TreeNode root = new TreeNode(pre[pl]); // root
    int leftSize = idxMap.get(root.key) - il; // how many nodes in left subtree

    // left subtree
    root.left = construct(in, il, il + leftSize - 1, pre, pl + 1, pl + leftSize, idxMap);
    root.right = construct(in, il + leftSize + 1, ir, pre, pl + leftSize + 1, pr, idxMap);
    return root;
  }
}
