package com.study.practice.data_structure;

import com.study.util.TreeNode;

public class Tester {
    public static void main(String[] args) {
        // Test BST:
        TreeNode root = null;
        BST bst = new BST();
        root = bst.insert_I(root,3);
        root = bst.insert_I(root,2);
        root = bst.insert_I(root,8);
        root = bst.insert_I(root,6);
        root = bst.insert_I(root,10);
        root = bst.insert_I(root,12);
        root = bst.insert_I(root,7);
        root = bst.deleteBST(root, 3);
        System.out.println(bst.searchBST_I(root,6));

        // Test Min Heap:
        int[] arr = new int[]{5,2,3,7,9,1};
        MinHeap minHeap = new MinHeap(arr);
    }
}
