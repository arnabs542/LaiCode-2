package com.study.algorithms.class10_recursion_2.重听;

import com.study.util.TreeNode;

public class LCA {
    // LCA 三部曲：
    // 1. 问孩子有没有one或者two，有的话给我 --> 剪枝的话，就不是第一行了
    // 2. 检查LCA：左右一个one、一个two； 孩子给一个，我是另一个； 这两个情况都是return自己  --> 可以优化剪枝情况2到第一步骤
    // 3. 如果不是return自己的情况，就return有料的孩子或者null
    // 如果保证一定有LCA，那么最后root返回的东西，就是LCA。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // assumption: root is not null, and one and two guaranteed to be in the tree.
        // base case:
        if (root == null) {
            return null;
        }
        // recursion rule:
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        if (root == one || root == two) { // 可以搬到递归调用前
            return root;
        }
        return left == null ? right : left;
    }
}
