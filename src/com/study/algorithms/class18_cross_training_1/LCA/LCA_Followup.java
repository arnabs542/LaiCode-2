package com.study.algorithms.class18_cross_training_1.LCA;

public class LCA_Followup {
  // Follow up:
  // 如果有k个node，把它们的LCA找到，
  // 如果分析隶属关系就太复杂了，应该理解物理意义：
  // LCA(root, nodes)的含义是：
  //    represents, in the subtree rooted at root,
  //    the LCA of all input nodes.
  // 返回值含义：
  //    如果我是abcd中的一个，返回自己。
  //    如果左边非空、右边也非空，那么就返回自己。（子树范围内，我是LCA）
  //    如果有一边空，返回另一边。（子树范围内的LCA）


  // 思考方法：凡是k个xxx的问题：
  // 1. iterative reduction: 不要k个节点一起找，而是两个两个搞：(((a,b),c),d)。
  // 2. binary reduction: 找最大的和次大的那个puzzle。
  // 3. k-way reduction: 真的是k个一起做。
}
