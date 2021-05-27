package com.study.algorithms.class08_DFS.重听;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    // input:
    //   int target
    //   int[] coins
    // output:
    //   List<List<Integer>> results
    //    a list of combinations

    // # of levels: coins.length
    // # of branch of each node: depends on remaining money
    //              100
    //             /||||\
    // 10         10   1 0
    //               /|||\
    // 5            18    0
    //
    // 2

    // Time Complexity: O(1) * O(target^n), n is the # of coins type
    // Space Complexity: O(n)

    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (target <= 0 || coins == null || coins.length == 0) {
            return result;
        }
        helper(target, coins, 0, cur, result);
        return result;
    }

    private void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
        // base case: （最佳，这样急剧降低nodes数量）（1）
        if (index == coins.length - 1) {
            if (target % coins[index] == 0) {
                cur.add(target / coins[index]);
                result.add(new ArrayList<Integer>(cur)); // 一定要new一个（2）
                cur.remove(cur.size() - 1);
            }
            return;
        }

        // recursion rule:
        for (int i = 0; i <= target / coins[index]; i++) { // 要包含等于的情况（3）
            cur.add(i);
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
