package com.study.algorithms.class07_DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
  //- The recursion tree has 4 levels,
  //- we consider how many time for one type of coin
  //- can be chosen in this level.
  //                      99 cents
  //                    /  |  |  \
  // L1 25cents        0   1  2   3(rem=24cents)
  //                  /\   /\ /\  /|\
  // L2 10cents                   0 1 2(rem=4cents)
  //                                  |
  // L3                               0
  //                                  |
  // L4                               4 (rem = 0cents)

  // signature of the：input: target(99cents), int[] how many types of coins we can use
  // each combination is represented as a List<Integer>, we can access it by result.get(i)
  // all the combination is represented as a List of List<Integer>
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> cur = new ArrayList<Integer>();
    helper(target, coins, 0, cur, result); // index starts from 0
    return result;
  }

  // moneyLeft: remaining cents we need to complete
  // coins: all the possible types of coins
  // index: used in finding how many coins we need for coins[index].
  private void helper(int moneyLeft, int[] coins, int index, List cur, List<List<Integer>> result) {
    // 优化版本的base case:
    if (index == coins.length - 1) {
      // 如何获知solution中前几个index的数量？多一个List buffer cur
      if (moneyLeft % coins[coins.length - 1] == 0) {
        cur.add(moneyLeft / coins[coins.length - 1]); // 吃了要记得还吐出去
        result.add(new ArrayList(cur)); //deepcopy， 否则只是加入了buffer的reference，后续还会变化。最后效果全是emptylist
        cur.remove(cur.size() - 1); // remove the last one
        return;
      } else {
        // cannot build a valid solution, jump over it!
        return;
      }
    }
    // 简单版本的base case:
    // if (index == coins.length) { // 走完和没有moneyLeft不能是&&，否则走完了、但是没有凑齐的情况会继续走，导致下标越界
    //   if (moneyLeft == 0) {
    //     result.add(new ArrayList(cur));
    //   }
    //   return;
    // }

    // for coins[index], we can pick 0, 1, 2, ..., (moneyLeft / coins[index]) coins.
    int max = moneyLeft / coins[index];
    for (int i = 0; i <= max; i++) {
      cur.add(i); // try to pick i coins
      helper(moneyLeft - i * coins[index], coins, index + 1, cur, result);
      cur.remove(cur.size() - 1); // restore the buffer for sibling's usage.
    }
  }
}
