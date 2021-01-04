package com.study.algorithms.class10_recursion_2.tree;

// How to store how many nodes in each nodes' left-subtree
// 注意：我的right不能直接丢弃，因为right里面也有“left-subtree”
public class NumNodesLeft {
    static class TreeNodeLeft {
    int key;
    TreeNodeLeft left;
    TreeNodeLeft right;
    int numNodesLeft;   // stores the # of nodes in left subtree.
    public TreeNodeLeft(int key) {
      this.key = key;
    }
  }

  public void numNodesLeft(TreeNodeLeft root) {
    // what I expect to get from my lChild and rChild:
    // my leftSubtree & rightSubtree nodes number.

    // what I do in my layer:
    // "my leftSubTree"

    // what I will return to my parent:
    // the sum of left and right subtree + 1
    nodesInSubtree(root);
  }
  public int nodesInSubtree(TreeNodeLeft root) {
    // base case:
    if (root == null) {
      return 0;
    }
    // recursion rule:
    int leftTotal = nodesInSubtree(root.left);
    int rightTotal = nodesInSubtree(root.right);
    root.numNodesLeft = leftTotal;
    return leftTotal + rightTotal + 1;
  }

}
