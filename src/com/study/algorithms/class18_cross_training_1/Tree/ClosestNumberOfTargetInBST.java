package com.study.algorithms.class18_cross_training_1.Tree;

public class ClosestNumberOfTargetInBST {
  // BST 一个任意两个所有：
  // 任意一个节点，左子树中所有nodes小于它，右子树中所有nodes大于它。

  // Method: 1
  // 回忆传统 k-th closest: binary serach + 中心开花 O(log(size) + k)
  // 本题如果按照这个方案，需要先变成sorted array，O(tree.size + log(tree.size) + k)
  //                                        Space: O(tree.size + tree.height)
  // Time = O(tree.size)
  // Space = O(tree.size + tree.height + k)  全部压扁为sorted array


  // Method: 2
  // 另一个更好的方法：
  // 利用BST的性质：什么叫离target最近的k个数？
  //    在数组上看，是连续的k个数。
  //     --> 维护一个closest subarray.
  //         每次visit node，判断新来的和以前的min or max哪个距离target更近
  // 这里的这个Queue，应该是个Deque。

  // code的逻辑：InOrder visit BST，expand的时候：先填满k，然后看是否有必要更新。
  //           找到了target，则返回当前的subarray。
  // InOrder的参数应该有root, subarray, k, target
  // Time: O(tree.size) 需要Deque来帮助我们poll和offer
  // Space: O(tree.height + k)
  // 优化：可以剪枝, 但是不影响复杂度

  // Method: 3
  // 不用递归，用iteration来实现in-order [1:31:00]
  // 让iterator中心开花，移动k次，每次开销最多O(h) --> amortized time O(k+h)

}
