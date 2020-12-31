package com.study.algorithms.class10_recursion_2;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
  // Method I
  // recursive traversal
  // matrix is not null, and side length >= 0
  // high level idea -> tell the next level about "offset, and side length"
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    recursiveTraverse(matrix, 0, matrix.length, result);
    return result;
  }
    /*
    {1,  2,  3},
    {4,  5,  6},
    {7,  8,  9},
     */

  //    1.没能正确判断base case。 --  偶数length==0；奇数length==1
//    2.通过for循环循环变量反向，降低题目的难度。
  private void recursiveTraverse(int[][] matrix, int offset, int length, List result) {
    // base case
    if (length == 0) { // 偶数边长
      return;
    }
    if (length == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    // recursive rule

    for (int i = 0; i < length - 1; i++) {
      result.add(matrix[offset][offset + i]);
    }
    for (int i = 0; i < length - 1; i++) {
      result.add(matrix[offset + i][offset + length - 1]);
    }
    for (int i = length - 1; i > 0; i--) { // 修改循环变量走向，更简单
      result.add(matrix[offset + length - 1][offset + i]);
    }
    for (int i = length - 1; i > 0; i--) {
      result.add(matrix[offset + i][offset]);
    }
    recursiveTraverse(matrix, offset + 1, length - 2, result);
  }

  // Method II tail recursion --> iteration
  public List<Integer> spiralIterative(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int offset = 0;
    int length = matrix.length;

    while (length >= 0) {
      // base case
      if (length == 0) { // 偶数边长
        return result;
      }
      if (length == 1) {
        result.add(matrix[offset][offset]);
        return result;
      }
      // recursive rule
      for (int i = 0; i < length - 1; i++) {
        result.add(matrix[offset][offset + i]);
      }
      for (int i = 0; i < length - 1; i++) {
        result.add(matrix[offset + i][offset + length - 1]);
      }
      for (int i = length - 1; i > 0; i--) { // 修改循环变量走向，更简单
        result.add(matrix[offset + length - 1][offset + i]);
      }
      for (int i = length - 1; i > 0; i--) {
        result.add(matrix[offset + i][offset]);
      }
      offset++;
      length -= 2;
    }
    return result;
  }
}
