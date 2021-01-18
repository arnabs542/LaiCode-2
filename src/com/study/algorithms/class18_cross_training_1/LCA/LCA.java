package com.study.algorithms.class18_cross_training_1.LCA;

import com.study.util.TreeNode;

public class LCA {
  // Given two nodes in a binary tree, find their lowest common ancestor.
  // TreeNode doesn't have parent field.

  // 物理意义：
  // LCA(root, one, two)的含义是：
  //    在以root为根的子树上，寻找并返回one和two的LCA。找不到则返回null。
  //   （定义LCA：如果one或者two不在，那么LCA就是另一个值）

  // case 1: 两个点有隶属关系 返回更高的那个点
  //  base case:
  //    1. null return null
  //    2. a or be, return a or b. --> 会覆盖掉下层传上来的那个，即当前的是LCA。
  //  recursion rule:
  //    1. if both child is null, return null
  //    2. if one of them is not null, return that one

  // case 2: 两个点没有隶属关系 共同祖先（left、right subtree分别可以找到one two）
  //  base case:
  //    1. null return null
  //    2. found one return that one
  //  recursion rule:
  //    1. both null, return null
  //    2. one is not null, return that one
  //  * 3. both are not null(found both), I am LCA.

  // case2可以囊括case1，case1中不会出现 *3的情况。

  // signature:
  // input: root, one, two
  // output: a possible LCA or not.

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // 物理意义：
    // LCA(root, one, two)的含义是：
    //    在以root为根的子树上，寻找并返回one和two的LCA。找不到则返回null。
    //   （定义LCA：如果one或者two不在，那么LCA就是另一个值）
    //    in the subtree rooted at root, the LCA of one and two.

    // base case: 这里体现了物理意义。
    if (root == null) {
      return null;
    }
    if (root == one || root == two) {
      return root;
    }
    // recursion rule:
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    // 情况3
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left; // 囊括1.2 两种情况
  }
}
