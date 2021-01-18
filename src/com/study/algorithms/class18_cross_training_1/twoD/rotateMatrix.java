package com.study.algorithms.class18_cross_training_1.twoD;

public class rotateMatrix {
  // 要in-place
  // 不要上下、左右颠倒，那个方法没有通用的知识。（而且比如旋转1格，那就不管用了）
  // 应该是recursion，每次的逻辑是within a layer（一圈）的。

  // (i,j) 顺时针90度， 绘图理解应该是到(j, length - 1 - i)
  // 旋转的时候应该是，应该是把spiral中四个for中同一位置的，进行一次替换。
  // 每层用一个for来实现。
}
