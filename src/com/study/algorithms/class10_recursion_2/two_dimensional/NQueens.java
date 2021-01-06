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
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>(); // store one way
    helper(n, cur, result);
    return result;
  }

  private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
    // base case: all rows are filled
    if (cur.size() == n) {      // 注意：cur.size()就是当前的row，没必要再写一个row。
      //result.add(cur);    // 注意：应该添加一个新的object，而不是添加一个reference就完事了
      result.add(new ArrayList<Integer>(cur));
      return;
    }
    // recursion rule: try each position of current row
    // 吃了要吐
    for (int col = 0; col < n; col++) {
      if (valid(cur, col)) {
        cur.add(col);
        helper(n, cur, result);
        cur.remove(cur.size() - 1); // 注意：remove 可以选择object或者index。我们这里是int，只能是选index。
      }
    }
  }

  private boolean valid(List<Integer> cur, int col) {
    int row = cur.size();
    for (int y = 0; y < cur.size(); y++) {
      int x = cur.get(y);
      if ((Math.abs(col - x) == (row - y)) || (col == x)) {
        return false;
      }
    }
    return true;
  }
}
