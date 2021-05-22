package com.study.algorithms.class13_DP_3;

//        Largest Square Of Matches
//        Determine the largest square surrounded by a bunch of matches (each match is either horizontal or
//        vertical), return the length of the largest square.
//
//        The input is a matrix of points. Each point has one of the following values:
//        0 - there is no match to its right or bottom.
//        1 - there is a match to its right.
//        2 - there is a match to its bottom.
//        3 - there is a match to its right, and a match to its bottom.
//
//        https://app.laicode.io/app/problem/638

public class LargestSquareOfMatches {
  public int largestSquareOfMatches(int[][] matrix) {
    // Assumptions: matrix is not null, size of M * N, where M, N >= 0
    // the elements in the matrix are either 0 or 1.
    if (matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int result = 0;
    int M = matrix.length;
    int N = matrix[0].length;
    // the longest right/down arm length ending at each position in the matrix.
    int[][] right = new int[M + 1][N + 1];
    int[][] down = new int[M + 1][N + 1];
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        if (hasRight(matrix[i][j])) {
          right[i][j] = right[i][j + 1] + 1;
        }
        if (hasDown(matrix[i][j])) {
          down[i][j] = down[i + 1][j] + 1;
        }
        if (hasBoth(matrix[i][j])) {
          // the maximum length of a surrounded by 1 matrix with top-left
          // position at matrix[i][j] is determined by the min value of
          // right[i][j] and down[i][j],
          // and we check one by one all the possible lengths if it can
          // provide the actual matrix.
          // we only need to check the longest bottom arm length of the bottom-left
          // cell and the longest right arm length of the top-right cell.
          for (int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1;
               maxLength--) {
            if (right[i + maxLength][j] >= maxLength && down[i][j + maxLength] >=
                    maxLength) {
              result = Math.max(result, maxLength);
              break;
            }
          }
        }
      }
    }
    return result;
  }

  private boolean hasRight(int value) {
    return (value & 0b1) != 0;
  }

  private boolean hasDown(int value) {
    return (value & 0b10) != 0;
  }

  private boolean hasBoth(int value) {
    return value == 0b11;
  }
}
