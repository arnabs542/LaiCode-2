package com.study.algorithms.class05_binary_tree;

import com.study.util.TreeNode;

public class Tester {

  public static void main(String[] args) {
    BasicBinaryTree tree = new BasicBinaryTree();
    TreeNode root = tree.initTree();
    //inLesson.preOrder(root);
//    int height = inLesson.findHeight(root);
//    System.out.println(height);
    tree.isBalanced(root);
  }
}
