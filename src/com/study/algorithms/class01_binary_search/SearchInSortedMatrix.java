package com.study.algorithms.class01_binary_search;

public class SearchInSortedMatrix {
  // 2D Matrix.
  // each row: in an ascending order
  // different row: first element of next row is larger than the previous row's last one

  // Question:
  // given a target number, returning the position that the target locates
  // return {-1, -1} if not exist

  // 注意，cols才是代表一行有多少个元素。

  public int[] search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[]{-1, -1};
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0;
    int right = rows * cols - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int col = mid % cols;
      int row = mid / cols;
      if (matrix[row][col] == target) {
        return new int[]{row, col};
      } else if (matrix[row][col] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return new int[]{-1, -1};
  }
}
