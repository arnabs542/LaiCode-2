package com.study.practice.class08_binary_tree_II;

import com.study.util.TreeNode;

public class PostOrder_Iter {
    // 先把递归拿出来：
    public void postOrderR(TreeNode root) { // root相当于是栈顶元素
        if (root == null) {
            return;
        }
        // S1:
        postOrderR(root.left);
        // S2:
        postOrderR(root.right);
        // S3:
        System.out.println(root.key);
    }
}
