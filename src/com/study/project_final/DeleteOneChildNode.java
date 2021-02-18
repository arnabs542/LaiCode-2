package com.study.project_final;

public class DeleteOneChildNode {
  // Assumption:
  class Node {
    int value;
    Node left;
    Node right;
  }

  // my solution:
  // recursion:
  //
  // What do I expect from my children?
  // - if my child’s  one child is null, it should return the not null child to me.
  // - otherwise, return itself (both null, both not null situation)
  //
  // what I do
  // - check if I got a not null return value, I need to connect it.
  //
  // what I report?
  // - check if one of my children is null, return the other one,
  // - otherwise, return itself

  // old root --> new root
  public Node deleteNode(Node root) {
    // base case:
    if (root == null) {
      return null;
    }

    // recursive rule:
    root.right  = deleteNode(root.left);
    root.left = deleteNode(root.right);

    if (root.left == null && root.right == null) {
      return root;
    } else if (root.left == null) {
      return root.right;
    } else if (root.right == null) {
      return root.left;
    } else {
      return root;
    }
  }

}
