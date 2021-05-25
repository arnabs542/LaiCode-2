package com.study.algorithms.class06_Binary_Search_Tree;

import com.study.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetRange {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> result = new ArrayList<>();
    getRange(root, min, max, result);
    return result;
  }

  private void getRange(TreeNode root, int min, int max, List<Integer> result) {
    if (root == null) {
      return;
    }
    // 1. determine whether left subtree should be traversed
    if (root.key > min) {
      getRange(root.left, min, max, result);
    }
    // 2. determine if the root node should be add into result;
    if (root.key >= min && root.key <= max) {
      result.add(root.key);
    }
    // 3. determine whether right subtree should be traversed
    if (root.key < max) {
      getRange(root.right, min, max, result);
    }
  }
}
