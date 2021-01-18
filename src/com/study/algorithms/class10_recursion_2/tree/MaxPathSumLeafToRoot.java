package com.study.algorithms.class10_recursion_2.tree;
import com.study.util.TreeNode;
// Max Path Sum From Leaf To Root

public class MaxPathSumLeafToRoot {
  public int maxPathSumLeafToRoot(TreeNode root) {
    // base case:
    // 之前情况下（直接max）：如果左孩子是null，右孩子是-100.那么会认为leaf到当前最大是0，而不是-100了。
    /*            -10
              -16       12
            -8  -15    # -12   <-- 问题出在这里。正确答案是-10最大，我说是2最大。原因是我在12这个node里认为max(left,right) = 0.没考虑0可能是null的返回值所以不能选。
         -2 3  -13 11
         */
    if (root == null) {
      return 0;
    }
    // recursion rule:
    // 1. get the max sum from left\right children -- notice the null
    // 2. compute the one that include this node
    // 3. return it -- 这个题目中，step2和step3的内容是统一的
    int left = maxPathSumLeafToRoot(root.left);
    int right = maxPathSumLeafToRoot(root.right);
    if (root.left == null && root.right == null) {
      return root.key;
    } else if (root.left == null || root.right == null) {
      return root.left == null ? (right + root.key) : (left + root.key);
    } else {
      return Math.max(left, right) + root.key;
    }
  }
}
