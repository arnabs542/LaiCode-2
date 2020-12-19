package com.study.practice.data_structure;
// 题目 https://app.laicode.io/app/problem/127
// 答案 https://docs.google.com/document/d/1A2UmU_4naHJaMjz5L1rfldVk0TGM4SBtlENyHg1aIY0/edit

public class LCA {
    static class TreeNodeP {
        public int key;
        public TreeNodeP left;
        public TreeNodeP right;
        public TreeNodeP parent;

        public TreeNodeP(int key, TreeNodeP parent) {
            this.key = key;
            this.parent = parent;
        }
    }

    static class Result {
        public TreeNodeP root;
        public int depth;

        public Result(TreeNodeP node, int depth) {
            this.root = node;
            this.depth = depth;
        }
    }

    // NOTICE, 不能一起往上走，每次判断，因为两个node的深度可能不同。
    // 思路：
    // 1. find the depth of both nodes (goes up to the root to find the depth)  O(2height)
    //    1.1  if the roots of the two nodes are different, then return null
    // 2. move the deeper node up to match the other's depth                    O(height)
    // 3. move both node and when they meet, that node is LCA                   O(height)

    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // 1. find depth
        Result res1 = getDepth(one);
        Result res2 = getDepth(two);
        // 1.1
        if (res1.root != res2.root) {
            return null;
        }
        // 2. move the deeper node up to match the other's depth
        // 3. move bot node and when they meet, that node is LCA
        if (res1.depth > res2.depth) {
            // heigher的放在前面
            return getLCA(two, one, res1.depth - res2.depth);
        } else {
            return getLCA(one, two,res2.depth - res1.depth);
        }
    }

    private TreeNodeP getLCA(TreeNodeP higherNode, TreeNodeP lowerNode, int diff) {
        while (diff > 0) {
            lowerNode = lowerNode.parent;
            diff--;
        }
        while (higherNode != lowerNode) {
            // compare address
            higherNode = higherNode.parent;
            lowerNode = lowerNode.parent;
        }
        return  lowerNode; // 一定会有答案
    }

    private Result getDepth(TreeNodeP node) {
        int depth = 0;
        while (node != null && node.parent != null) {
            node = node.parent;
            depth++;
        }
        return new Result(node, depth);
    }
}
