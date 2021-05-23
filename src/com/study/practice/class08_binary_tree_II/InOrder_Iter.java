package com.study.practice.class08_binary_tree_II;

import com.study.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

// 放弃掉这个inorder，它会干扰我的思路
// PreOrder和PostOrder的思路是统一的


public class InOrder_Iter {
    // 基于的递归方案：（带helper的） 感觉helper相当于输入的root。
    public void inOrderRecur(TreeNode helper) {
        if (helper == null) {
            return; // return到 S2
        }
        // S1
        inOrderRecur(helper.left); // 进入下一层，相当于压入当前层。
        // S2
        System.out.println(helper.key); // visit栈顶
        inOrderRecur(helper.right); // "尾递归", helper = helper.right
    }


    // 迭代地进行中序遍历：
    public void inOrder(TreeNode root) {
        // preparation
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root; // first input is root.

        // recursive --> iterative
        while (!stack.isEmpty() || helper != null) {    // exit when helper == null && isEmpty
            // S2
            if (helper == null) {
                helper = stack.pollFirst();
                System.out.println(helper.key);
                helper = helper.right;
            }
            // S1
            else {
                stack.offerFirst(helper);
                helper = helper.left;
            }
        }
    }


}
