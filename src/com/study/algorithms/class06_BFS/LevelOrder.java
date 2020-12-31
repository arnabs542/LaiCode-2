package com.study.algorithms.class06_BFS;

import com.study.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
  // i.e. BST
  //        8
  //     /      \
  //    2       98
  //     \      /  \
  //      18  1   100
  //          /
  //         1
  //
  // [null 18 1 100]
  // [8 2 98]
  public static Integer[] levelOrder(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    result.add(root.key);

    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (cur.left != null) {
        result.add(cur.left.key);
        queue.offer(cur.left);
      } else {
        result.add(null);
      }

      if (cur.right != null) {
        result.add(cur.right.key);
        queue.offer(cur.right);
      } else {
        result.add(null);
      }
    }
    return result.toArray(new Integer[result.size()]);
  }
}
