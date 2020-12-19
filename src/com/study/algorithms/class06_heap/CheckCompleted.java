package com.study.algorithms.class06_heap;

import com.study.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // if the flag is set true, there should not be any child nodes afterward!
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // if any of the child is not present, set the flag to true.

            // logic to left child
            if (cur.left == null) { // CASE1 cur.left == null
                flag = true;
            } else if (flag) { // CASE2 cur.left != null && flag == true;
                return false;
            } else { // CASE3 cur.left != null && flag == false;
                queue.offer(cur.left);
            }
            // same logic applied to the right child:
            if (cur.right == null) { // CASE1 cur.right == null
                flag = true;
            } else if (flag) { // CASE2 cur.right != null && flag == true;
                return false;
            } else { // CASE3 cur.right != null && flag == false;
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
