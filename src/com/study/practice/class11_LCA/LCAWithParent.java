package com.study.practice.class11_LCA;

public class LCAWithParent {
    // 1. 从定义出发，可以把一个的parent存到hashset里，另一个负责比较自己的parent在不在里面。
    //    但是发现没必要存储非LCA的parent到空间里，有空间的浪费 O(height)

    // 2. 可以先通过parent来求height，调整到一层上，然后网上一起走。空间是O(1)

    // corner case:
    //  - 不在一棵树里：找到root，依然没有碰到common

    public TreeNodeP lowestCommonAncestor(TreeNodeP a, TreeNodeP b) {
        if (a == null || b == null) {
            return null;
        }
        // 先找height，然后调整到同一层
        int aHeight = height(a);
        int bHeight = height(b);
        while (aHeight > bHeight) {
            a = a.parent;
            aHeight--;
        }
        while (aHeight < bHeight) {
            b = b.parent;
            bHeight--;
        }

        while (a != b) {
            if (a == null || b == null) { // 有可能不在一棵树上
                return null;
            }
            a = a.parent;
            b = b.parent;
        }

        return a;
    }

    private int height(TreeNodeP node) {
        int count = 1;
        while (node.parent != null) {
            count++;
            node = node.parent;
        }
        return count;
    }
}
