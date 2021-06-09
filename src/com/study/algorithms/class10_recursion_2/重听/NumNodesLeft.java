package com.study.algorithms.class10_recursion_2.重听;

import com.study.util.TreeNodeLeft;

public class NumNodesLeft {
    public void numNodesLeft(TreeNodeLeft root) {
        // 要求每个node记录自己left subtree的node个数
        helper(root);
    }

    // what do you expect from you left/right child: left sum, right sum
    // what do you want to do in the current layer: record left sum
    // what do you want to report to your parent:  report left+right+1
    private int helper(TreeNodeLeft root) {
        // base case:
        if (root == null) {
            return 0;
        }
        // recursion rule:T
        int left = helper(root.left);
        int right = helper(root.right);
        root.numNodesLeft = left;
        return left + right + 1;
    }
}
