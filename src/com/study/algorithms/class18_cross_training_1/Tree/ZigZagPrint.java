package com.study.algorithms.class18_cross_training_1.Tree;

public class ZigZagPrint {
  // 保留queue的物理意义不变：
  //    while循环每层一次，while循环进入的时候queue一定从左到右维护了当前level所有节点。
  // 改变顺序：
  //    偶数层先expand右边的，存到一个Deque里面。
  //    从queue的另一头塞入。（Deque）
  // 奇数层：从左边expand当前层size次，generate的时候从右边入queue，而且先generate right child。
  // 偶数层：从右边expand当前层size次，generate的时候从左边入queue，而且先generate left child。

}
