package com.study.algorithms.class07_Heap_and_Graph_Search;

import com.study.util.TreeNode;

import java.util.*;

public class Get_Keys_In_Binary_Tree_Layer_By_Layer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        // corner case:
        if (root == null) {
            return list;
        }
        // loop
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int size = queue.size();
        while (size != 0) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.key);
                if (cur.left != null) {
                    queue.add(cur.left); // null不能加入，就算能加入也不让加（否则cur.key会NPE）
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add(level);
            size = queue.size();
        }
        return list;
    }
}
