package com.study.algorithms.finalexam;

import com.study.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class question2 {

  //class TreeNode {
  //  int key;
  //  TreeNode left;
  //  TreeNode right;
  //}
  // In a binary tree, two nodes are cousins of each other
  // if they are at the [same level] and have [different parents].

  // Level relationship --> BFS
  // Assume root, n1, n2 is not null.
  public boolean areCousins(TreeNode root, TreeNode n1, TreeNode n2) {
    // basic level order BFS
    List<List<TreeNode>> levels = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      List<TreeNode> oneLevel = new ArrayList<>();
      int num = queue.size();
      for (int i = 0; i < num; i++) { // one level
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          oneLevel.add(cur.left);
          queue.offer(cur.left);
        } else {
          oneLevel.add(null);
        }

        if (cur.right != null) {
          oneLevel.add(cur.right);
          queue.offer(cur.right);
        } else {
          oneLevel.add(null);
        }
      }
      levels.add(new ArrayList<>(oneLevel));
      // try to locate a node
      if (oneLevel.contains(n1) && oneLevel.contains(n2)) {
        // return haveDifferentParent(n1, n2);
      }
    }
    return false;
  }
}
