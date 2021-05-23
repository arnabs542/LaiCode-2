package com.study.practice.class08_binary_tree_II;

import com.study.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrder_Iter {
    // 先把递归拿出来：
    public void preOrderR(TreeNode root) { // root相当于是栈顶元素
        if (root == null) {
            return;
        }
        // S1:
        System.out.println(root.key);
        preOrderR(root.left);
        // S2:
        preOrderR(root.right);
    }
}
