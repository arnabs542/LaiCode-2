package com.study.algorithms.class10_recursion_2.two_dimensional;

import java.util.ArrayList;
import java.util.List;

// {1,  2,  3,  4},
// {5,  6,  7,  8},
// {9, 10, 11, 12}

// 1 2 3
// 4 8
// 12 11 10
// 9 5

// 6 7

// even side length -> 0
// odd side length -> 1


public class SpiralTraverseII {
  StringBuilder sb = new StringBuilder();

  public List<Integer> spiral(int[][] matrix) {
    // Assumption: the matrix is not null and the two sides' length > 0
    List<Integer> result = new ArrayList<>();
    int offset = 0;
    int height = matrix.length;
    int width = matrix[0].length;
    while (true) {
      if (height == 0 || width == 0) {
        return result;
      } else if (height == 1) { // one row left
        for (int i = 0; i < width; i++) {
          result.add(matrix[offset][offset + i]);
        }
        return result;
      } else if (width == 1) { // one column left
        for (int i = 0; i < height; i++) {
          result.add(matrix[offset + i][offset]);
        }
        return result;
      }

      for (int i = 0; i < width - 1; i++) {
        result.add(matrix[offset][offset + i]);
      }
      for (int i = 0; i < height - 1; i++) {
        result.add(matrix[offset + i][offset + width - 1]);
      }
      for (int i = width - 1; i > 0; i--) {
        result.add(matrix[offset + height - 1][offset + i]);
      }
      for (int i = height - 1; i > 0; i--) {
        result.add(matrix[offset + i][offset]);
      }

      offset++;
      width -= 2;
      height -= 2;
    }
  }
}
