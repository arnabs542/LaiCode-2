package com.study.practice.data_structure;

import com.study.util.TreeNode;

public class BST {
  // TOPIC: SEARCH
  // 1 recursive 注意层层传递
  public TreeNode searchBST_R(TreeNode root, int target) {
    // base case
    if (root == null) {
      return null;
    } else if (target == root.key) {
      return root;
    }
    // recursion rule
    if (target < root.key) {
      return searchBST_R(root.left, target);
    } else {
      return searchBST_R(root.right, target);
    }
  }

  // 2 iterative
  public TreeNode searchBST_I(TreeNode root, int target) {
    while (root != null && root.key != target) {
      if (target < root.key) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return root;
  }

  // TOPIC: INSERT
  // 1 recursion
  public TreeNode insert_R(TreeNode root, int key) {
    // insert the target into the tree represented by root.
    // return the updated tree's root node

    // base case: find an ideal position or find the target is already existed
    if (root == null || root.key == key) {
      return new TreeNode(key);
    }
    // recursion rule: update myself(acting as parent\prev) and return myself.
    if (key < root.key) {
      root.left = insert_R(root.left, key);
    } else {
      root.right = insert_R(root.right, key);
    }
    // return updated root
    return root;
  }

  // 2 iteration
  public TreeNode insert_I(TreeNode root, int key) {
    // 不想要prev变量，需要停在叶子节点上，而不是直接走到坑里。
    if (root == null) {
      return new TreeNode(key);
    }
    TreeNode cur = root; // root 不能动，因为以后还要用于返回。
    while (cur.key != key) { // while 没找到：即还没走到已经被插入的节点上。
      if (key < cur.key) {
        if (cur.left == null) { // 提前看一眼，就不会走坑里
          cur.left = new TreeNode(key);
        } // 这里不需要else，有else的话会多一次loop
        cur = cur.left;
      } else {
        if (cur.right == null) { // 提前看一眼，就不会走坑里
          cur.right = new TreeNode(key);
        } // 这里不需要else，有else的话会多一次loop
        cur = cur.right;
      }
    }
    return root;
  }

  // TOPIC: DELETE
    /*
    case 1,2: left child is null: parent.xx = xx.right
    case 3: right is null: parent.xx = xx.left
    case 4: replace xx by the smallest one of its right subtree
            4.1: right child has no left child - xx.right.left = xx.left; parent.xx = xx.right
            4.2: right child has left child -
                    1. use while loop to find the node with null left child
                    2. pass its right child to its parent's left hand
                    3. replace xx by this node by reassigning left\right child

    use a recursive function, we can omit the parent.xx, and use return.
     */
  public TreeNode deleteBST(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    // find the key recursively
    // base case:
    if (key < root.key) {
      root.left = deleteBST(root.left, key); // acting as "prev"
      return root;
    } else if (key > root.key) {
      root.right = deleteBST(root.right, key); // acting as "prev"
      return root;
    } else { // key == root.key
      // we guarantee root != null && root.key == key
      // case 1,2
      if (root.left == null) {
        return root.right; // return it to reassign prev.xx
      }
      // case 3
      else if (root.right == null) {
        return root.left;
      }
      // case 4.1
      else if (root.right.left == null) {
        root.right.left = root.left;
        return root.right;
      }
      // case 4.2
      else { // root.right.left != null
        TreeNode newRoot = findSmallest(root.right);// 易错: 在右子树中找最小，所以cur不是从root开始，而是从root.right开始。
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
      }
    }
  }

  private TreeNode findSmallest(TreeNode root) {
    while (root.left.left != null) { //NO NPE, SINCE root.left does exist.
      root = root.left;
    }
    TreeNode smallest = root.left;
    root.left = root.left.right; // 易错: 交给爷爷的“左手”带了。而不是给右手。
    return smallest;
  }
}
