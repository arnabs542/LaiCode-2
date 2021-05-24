package com.study.algorithms.class07_BFS;

import com.study.util.TreeNode;

import java.util.*;

public class PostOrder {
  // Method 1: post-order is the reverse order of pre-order.
  // write a pre-order iterative solution, and reverse the result.
  public List<Integer> postOrderI(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      result.add(cur.key);
      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }
      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
    }
    Collections.reverse(result);
    return result;
  }

  // 时间还是O(n)，
  // 但是空间从O(height)变成O(n)了，
  // 因为要store everything in memory before we can get the whole post order traversal sequence.

  // Method 2: check the relation between the current node and the previous node
  // to determine which direction should go next.
  // from parent --> try go left. try go right. if not, record and pop.
  // from left -->
  // from right --> poll from stack, add myself to result

  public List<Integer> postOrderII(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    TreeNode cur = root;
    TreeNode prev = null;
    while (!stack.isEmpty()) {
      cur = stack.peekFirst();
      if (prev == null || cur == prev.left || cur == prev.right) { // CASE 1: from parent
        if (cur.left != null) { // try go left
          stack.offerFirst(cur.left);
        } else if (cur.right != null) { // try go right
          stack.offerFirst(cur.right);
        } else { // pop & add result
          result.add(stack.pollFirst().key);
        }
      } else if (prev == cur.left) { // CASE 2: from left
        if (cur.right != null) { // try go right
          stack.offerFirst(cur.right);
        } else { // pop & add result
          result.add(stack.pollFirst().key);
        }
      } else { // CASE 3: from right
        result.add(stack.pollFirst().key);
      }
      prev = cur; // 可以把这条拎出来
    }
    return result;
  }
  // time: O(n)
  // space: O(h) -- 不是O(n)了，因为不需要一个temp container来翻转一下了。
}
