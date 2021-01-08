package com.study.algorithms.class13_DP_3;

public class LargestCrossOfOnes {
  // Assumption: the matrix is not null and has size of M * N, where M > 0 and N > 0
  public int largest(int[][] matrix) {
    // sanity check
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    // do largest consecutive 1 for each element in four directions
    // M1 - left -> right
    // M2 - left <- right
    // M3 - up -> down
    // M4 - up <- down

    int m = matrix.length; // how many rows
    int n = matrix[0].length; // how many element in a row
    int[][] M1 = new int[m][n];
    int[][] M2 = new int[m][n];
    int[][] M3 = new int[m][n];
    int[][] M4 = new int[m][n];

    // left to right
    for (int row = 0; row < m; row++) {
      int count = 0;
      for (int col = 0; col < n; col++) {
        if (matrix[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        M1[row][col] = count;
      }
    }

    // right to left
    for (int row = 0; row < m; row++) {
      int count = 0;
      for (int col = n - 1; col >= 0; col--) { // edit here
        if (matrix[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        M2[row][col] = count;
      }
    }

    // up down, reverse the containment relationship of these two for-loop
    for (int col = 0; col < n; col++) {
      int count = 0;
      for (int row = 0; row < m; row++) {
        if (matrix[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        M3[row][col] = count;
      }
    }

    // down up
    for (int col = 0; col < n; col++) {
      int count = 0;
      for (int row = m - 1; row >= 0; row--) { // edit here
        if (matrix[row][col] == 1) {
          count++;
        } else {
          count = 0;
        }
        M4[row][col] = count;
      }
    }

    // find the maximum of the merged matrix
    return merge(M1, M2, M3, M4);
  }

  private int merge(int[][] M1, int[][] M2, int[][] M3, int[][] M4) {
    // input four matrix with same size
    // output the maximum of each MIN(m1, m2, m3, m4), where mi is an NON-ZERO element of Mi!
    // 问题1：求的是“merged”的最大值。即先求四个的最小值，再求最大值。
    // 问题2：上面求四个的时候，要看清楚。
    int MaxOfMin = Integer.MIN_VALUE;
    for (int row = 0; row < M1.length; row++) {
      for (int col = 0; col < M1[0].length; col++) {
        int min = Math.min(M1[row][col], Math.min(M2[row][col], Math.min(M3[row][col], M4[row][col])));
        if (min > MaxOfMin) {
          MaxOfMin = min;
        }
      }
    }
    return MaxOfMin; // arm length
  }
}
