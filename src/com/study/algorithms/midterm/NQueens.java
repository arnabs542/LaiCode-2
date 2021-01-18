package com.study.algorithms.midterm;

import java.util.ArrayList;
import java.util.List;

/*
* Find all valid ways of putting N Queens on an N * N chessboard
* so that no two Queens can attack each other
* (two queens can attack each other if they are on the same row/column or same diagonal line).
*
* You can define your own way of how to print the solution,
* e.g. using a size N array/List to record which column the queen occupies on each row.
* */
public class NQueens {
  // CA (clarify and assumption)
  // input: int n,
  // output: List<List<Integer>> a list of solution, each solution is a size n list. each element stands for the column of a row.
  // return empty list if no solutions are found

  // Resolution:
  // using DFS:
  // 1. n levels, each level represents a row
  // 2. n-i branches, n-i possible place to put a queen in the row. i is the current level.

  //                        root
  //                     / ||||||\
  //1st row:  Q(0,0)   Q(0,1)   Q(0,2) ... Q(0,7)       put first queen into first row;
  //          /|||||\      ..       ..       ..
  //2st row: Q(1,0) Q(1,1).....
  //        invalid  /||||||\
  //        ...
  // last row: Q(x,y)

  // Time: O(n! * n) 前者是总node个数，后者是每次check的开销

  public List<List<Integer>> nQueens(int n) {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    helper(n, cur, results);
    return results;
  }

  private void helper(int n, List<Integer> cur, List<List<Integer>> results) {
    // base case: cur.size() == n --> add a solution
    if (cur.size() == n) {
      results.add(new ArrayList<>(cur));
    }
    // recursion rule:
    for (int i = 0; i < n; i++) {
      if (!passCheck(i, cur)) {
        continue;
      }
      cur.add(i);
      helper(n, cur, results);
      cur.remove(cur.size() - 1);
    }
  }

  private boolean passCheck(int col, List<Integer> cur) {
    int row = cur.size(); // row starts from 0
    for (int pRow = 0; pRow < cur.size(); pRow++) {
      int pCol = cur.get(pRow);
      if (pCol == col || (row - pRow) == Math.abs(col - pCol)) { // 后面的情况包含对角线和反对角线攻击，所以要加绝对值。
        return false;
      }
    }
    return true;
  }
}
