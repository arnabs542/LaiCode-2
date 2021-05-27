package com.study.algorithms.class07_Heap_and_Graph_Search;

import java.util.*;

public class KthSmallestInSortedMatrix {
  static class Cell {
    int row;
    int column;
    int value;

    Cell(int row, int column, int value) {
      this.row = row;
      this.column = column;
      this.value = value;
    }
  }

  /**
   * Assumptions:
   * 1. a valid matrix: matrix is not null, N * M where N > 0 and M > 0
   * 2. a valid k: k > 0 and k <= N * M
   */
  public int kthSmallest1(int[][] matrix, int k) {
    int rows = matrix.length;
    int columns = matrix[0].length;
    // Best First Search, need a minHeap on the value of each cells.
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, (Cell c1, Cell c2) -> {
      if (c1.value == c2.value) {
        return 0;
      }
      return c1.value < c2.value ? -1 : 1;
    });
    // all the generated cells will be marked true,
    // to avoid being generated more than once.
    boolean[][] visited = new boolean[rows][columns];
    minHeap.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;

    // iterate k-1 rounds, and Best First Search the smallest k-1 cells;
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();  // 注意！必须要poll，因为需要让停下来时，第k个在root
      // the neighbor cell will be inserted back to the minheap
      // only if :
      //   1. it is not out of boundary. (this is a matrix)
      //   2. it has not been generated before. (this is a graph, not a tree)
      if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
        minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
        visited[cur.row + 1][cur.column] = true;// NOTICE: mark this node are visited(expanded)
      }
      if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
        minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
        visited[cur.row][cur.column + 1] = true;
      }
    }
    return minHeap.peek().value;
  }
  // time: O(klogk), 因为一次最多add 2个node，一共add k次，所以heap最大也就是2k个。
  // space: O(mn + k), where m is the row of matrix, n is the column of matrix.


  // 重听时重新写的一遍：
  public int kthSmallest(int[][] matrix, int k) {
  /*Assumptions
      the matrix is not null, N > 0 and M > 0
      K > 0 and K <= N * M
  Examples  -- each row and col are sorted in ascending order.
    { {1,  3,   5,  7},
      {2,  4,   8,  9},
      {3,  5,  11, 15},
      {6,  8,  13, 18} }

    the 5th smallest number is 4
    the 8th smallest number is 6*/

    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || k <= 0) {
      System.out.println("Invalid param");
      return -1; // 假设matrix非负，-1不可能是一个value。
    }

    int rows = matrix.length;
    int cols = matrix[0].length;
    Queue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() { // 这个() 是call constructor
      @Override
      public int compare(Cell o1, Cell o2) {
        return o1.value < o2.value ? -1 : 1;
      }
    });
    boolean[][] visited = new boolean[rows][cols];
    minHeap.offer(new Cell(0,0,matrix[0][0]));
    visited[0][0] = true;
    while (!minHeap.isEmpty()) {
      // expand
      Cell cell = minHeap.poll();
      k--;
      if (k == 0) {
        return cell.value;
      }
      // generate
      if (cell.row + 1 < rows && !visited[cell.row + 1][cell.column]) {
        minHeap.offer(new Cell(cell.row + 1, cell.column, cell.value + matrix[cell.row + 1][cell.column]));
        visited[cell.row + 1][cell.column] = true;
      }
      if (cell.column + 1 < cols && !visited[cell.row + 1][cell.column]) {
        minHeap.offer(new Cell(cell.row, cell.column + 1, cell.value + matrix[cell.row][cell.column + 1]));
        visited[cell.row][cell.column + 1] = true;
      }
    }
    return 0;
  }
}
