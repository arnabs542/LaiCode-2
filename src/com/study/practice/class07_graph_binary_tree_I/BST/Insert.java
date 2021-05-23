package com.study.practice.class07_graph_binary_tree_I.BST;

import com.study.util.TreeNode;

public class Insert {
  // 如果没有counter，就直接回去
  // 有counter，就counter++

  // 函数签名设计：
  // 1. 返回值：caller手中的root可能会变化（输入null），所以应该返回new root
  //            递归时，如果要insert，那必然input是null

  // recursion
  public TreeNode insert(TreeNode root, int target) {
    // base case
    if (root == null) {
      return new TreeNode(target);
    }
    if (root.key == target) {
      return root;
    }

    // recursion rule:
    if (root.key > target) {
      root.left = insert(root.left, target);
    } else {
      root.right = insert(root.right, target);
    }
    return root;
  }


  // iteration (cur可能会掉坑里，即走到null了)
  // solution1: 留一个prev，等cur掉null里面了，就挂target到prev。
  // solution2: 多看一步，没掉坑里就自己发现了
  // 注意，最后还是要返回original的root。所以要留一个original root。

}
