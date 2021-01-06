package com.study.algorithms.class10_recursion_2.two_dimensional;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
  // Get all valid ways of putting N Queens on an N * N chessboard
  // So that no two Queens threaten each other

  // Method1: DFS
  // validate the queen position in O(n) each time

  // in this DFS:
  //  how many levels?
  //    n levels, stand for n queens
  //  how many branch of each node?
  //    n positions(col) of a queen in a row, need to be validated whether to choose or not.

  // Assumptions: n > 0
  // return a list of ways of putting the n queens
  // each way is represented by a list of queens' col for row of 0 to n-1.

  // 三个错误总结：
  // 1. add到result的时候，没有new一个新的。那么这个结果会随着DFS而变化。
  // 2. cur.size()才是获得length，含义是row走到哪里了。不需要另一个row了
  // 3. 判断能否斜着攻击是 Math.abs(col - x) == (row - y) 因为y不会大于row。不要用除法是否为1.
  // 三个API操作：
  // 1. get(index)  获取index对应的object，下标从0开始
  // 2. size()      不是length()
  // 3. remove(index / object)  用于删除，不是delete。  我们这里add的时候当object放，但是remove的时候要写index

  /*********************************************************************************************/


  // assumption: n > 0
  //             n queens put on n*n checkerboard
  // input: # of queens
  // ouput: a list of solution, each solution is a list of size n
  // in this list, index is the row and the it's value is the position(col) in that row.

  public List<List<Integer>> nQueens(int n) {
    List<List<Integer>> result = new ArrayList<>(n);
    List<Integer> cur = new ArrayList<>(n);
    helper(n, cur, result);
    return result;
  }

  private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
    // base case: all queens have been put on checkboard
    if (n == cur.size()) {
      result.add(new ArrayList<>(cur)); // a new object
      return;
    }
    // recursion rule: try each possible position of current row
    for (int col = 0; col < cur.size(); col++) {
      if (valid(col, cur)) {
        // try one position
        cur.add(col);
        helper(n, cur, result);
        // after try it, remove it so as not to influence the next loop.
        cur.remove(cur.size() - 1);
      }
    }
  }

  private boolean valid(int col, List<Integer> cur) {
    // row is the size of cur
    int row = cur.size();
    // this queen's position is (col, row)
    // one of previous queen's is (x, y)
    for (int y = 0; y < cur.size(); y++) {
      int x = cur.get(y);
      if (Math.abs(x - col) == (row - y) || x == col) {
        // diagonal || same column --> cannot be same row, we make sure it
        return false;
      }
    }
    return true;
  }
}
