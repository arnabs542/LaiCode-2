package com.study.algorithms.class05_binary_tree;


import com.study.util.TreeNode;

public class BasicBinaryTree {
    public TreeNode initTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(77);
        root.left.left.left.left = new TreeNode(88); // this line break the rule
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(20);
        return root;
    }



    // 时间复杂度: n个node的话，把树画一下，最多有n个null，所以是O(2n)时间复杂度
    // 空间复杂度：n个node的话，最差是糖葫芦串，最多n+1层。所以O(height) 最差时height是n+1
    // tree - related recursive
    // 1. 把null当做base case
    public void preOrder(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // visit root
        System.out.println(root.key);
        // visit left
        preOrder(root.left);
        // visit right
        preOrder(root.right);
    }



    // height of binary tree
    // time: O(n)
    // space: O(height)
    public int findHeight(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // recursion call
        // 1. 问（孩子）：希望孩子返回以他们为root的subtree的height
        // 2. 汇总：求以自己为root的tree的height = max(lh, rh) + 1
        // 3. 汇报：my height

        //  0  --  got (1), (2)，so my height:2+1 = 3     <-- high level
        // / \
        // 1  2
        //     /\
        //    3  4

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1; // 1是自己
    }



    // balanced binary tree
    // for each node, the height of its left subtree and right subtree (differ by 1 or less)
    //        0
    //     /    \
    //    1      2
    //    /\     /
    //   3  4    6
    //   /
    //   5
    // 判断是否是平衡二叉树?
    // 任何一个节点，左右子树高度差都小于等于1，所以其实这个是平衡二叉树哈哈。 所以平衡二叉树的subtree高度可以是10 9 8 7 6 5 ，，， 2 是没问题的
    // for each node, heights of left nad right subtrees differ 1 or less
    // time: O(n)
    // space: O(height)
    static class Res {
        int height;
        boolean isBalanced;

        public Res(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        Res res = new Res(0, false);
        res = helper(root);
        System.out.println("height is " +  res.height + "; isBalanced is " + res.isBalanced);
        return res.isBalanced;
    }
    private Res helper(TreeNode root) {
        // base case:
        if (root == null) {
            return new Res(0, true);
        }
        // recursion rule:
        Res left = helper(root.left);
        Res right = helper(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced;
        if (Math.abs(left.height - right.height) > 1) {
            isBalanced = false;
        }
        return new Res(height, isBalanced);
    }
    // 也可以使用 -1 代表not balanced


    // 不太好的方法（但是可以学习时间复杂度计算）
    // time: O(nlogn) 按level求，最差情况是Balanced BinaryTree：time of each level: O(n) , # of levels: O(logn) ==> O(nlogn)
    // space: O(height)
    public boolean isBalancedBad(TreeNode root) {
        // base case:
        if (root == null) {
            return true;
        }
        // recursion rule:
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            // pruning
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right); // short-circuit: if left part is false, right part won't be compute
        // 如果没有短路，单独求这两个，那么最差情况是糖葫芦串而不再是平衡二叉树。O(n^2)的复杂度
    }
}
