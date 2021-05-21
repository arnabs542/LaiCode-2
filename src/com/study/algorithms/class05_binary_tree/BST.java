package com.study.algorithms.class05_binary_tree;

public class BST {
    // BST, binary search tree
    //   左子树所有节点都小于它（而不只是左孩子）
    //   右子树所有节点都大于它
    // 注意：BST不一定是balanced， 如下：
    //        5
    //       /
    //      4
    //     /
    //    3
    // 所以time不能说是O(logn)啥的，只有RB、AVL这些自平衡的二叉搜索树才行。

    // 如过有重复元素呢？
    //   存储这个值出现了多少次，比如存储(5,4,3,4)
    //        5,1
    //       /
    //      4,2
    //     /
    //    3,1

    // 如何insert：
    //
}
