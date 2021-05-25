package com.study.algorithms.class05_binary_tree;


import com.study.util.TreeNode;

public class ReconstructTreeFromLevelOrder {
  public static TreeNode constructTree(Integer[] levelOrder) {
    // input is a CBT including null
    // do a reverse engineering on BST using a queue
    if (levelOrder == null || levelOrder.length == 0) {
      return null;
    }
    TreeNode[] nodes = new TreeNode[levelOrder.length];
    for (int i = 0; i < levelOrder.length; i++) {
      if (levelOrder[i] == null) {
        nodes[i] = null;
      } else {
        nodes[i] = new TreeNode(levelOrder[i]);
      }
    }
    for (int i = 0; i < levelOrder.length; i++) {
      if (nodes[i] == null) {
        continue;
      }
      if (i * 2 + 1 < levelOrder.length) {
        nodes[i].left = nodes[i * 2 + 1];
      }
      if (i * 2 + 2 < levelOrder.length) {
        nodes[i].right = nodes[i * 2 + 2];
      }
    }
    return nodes[0]; // root
  }

  public static void main(String[] args) {
    Integer[] array = new Integer[]{8, 2, 98, null, 18, 1, 100};
    //        8
    //     /      \
    //    2       98
    //     \      /  \
    //      18  1   100
    //
    // preOrder: 8 2 18 98 1 1 100
    TreeNode root = constructTree(array);           // Integer[] --> Tree (TreeNode)
    preOrder(root);
    Integer[] result = LevelOrder.levelOrder(root); // Tree (TreeNode) --> Integer[] (ArrayList -> toArray(new Integer[size]))
    System.out.println();
    TreeNode root2 = constructTree(result);
    preOrder(root2);
  }

  private static void preOrder(TreeNode root) {
    // base case:
    if (root == null) {
      return;
    }
    // recursion rule
    System.out.println(root.key);
    preOrder(root.left);
    preOrder(root.right);
  }
}
