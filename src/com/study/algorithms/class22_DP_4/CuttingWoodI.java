package com.study.algorithms.class22_DP_4;

// There is a wooden stick with length L >= 1, we need to cut it into pieces
// The cutting positions are pre-defined in an int array A.
// Array A is an int array, represents these positions in ascending order.

// The cost of each cut is the length of the stick segment being cut.
// Determine the minimum total cost to cut the stick into the defined pieces.
public class CuttingWoodI {
  // input: int array (all positions to cut), total length of the board.
  // output: int (minimum cost)

  // Solution: DP
  /*
  * HighLevel: dp数组所代表的是问题的(解的)集合
    所以dp数组应该代表“完全切割某一段的min cost”这个含义

    这样，dp数组中的某个element就可以拆分了：
    直观上看：
    “完全切割某一段的min cost”
     = “把它切成两半的cost” +  “完全切割左侧的min cost” +  “完全切割右侧的min cost”

    考虑到这一刀怎么切有多重做法，则：
    “完全切割某一段的min cost”
     = “把它切成两半的cost” +  min(“完全切割左侧的min cost” +  “完全切割右侧的min cost”)
  * */


  // - meaning:
  // dp(i,j) represents the minimum total cost of cutting board [a[i],a[j]] into required segments
  // array 要加上0 和 length
  // 填写上三角矩阵即可：
  //   j是end position，从第一个可切割位置，到木板的结尾位置
  //   i是start position，从木板开始的位置，到j前面一个的位置

  // - base rule:
  // 由于切下来的段落是[a[i],a[j]] 所以 i,j 相邻的时候值为0，即已经是segment的时候不用再切。

  // - induction rule:
  // dp(i,j)  = (cost of this cut) + min{(cost of left sub-problem) + (cost of right sub-problem)}
  //          = (a[j]-a[i]) + min{dp(i,k) + dp(k,j) | i < k < j, k is an element of input array}
  // 由于在求解(i,j)答案时，需要知道(k,j)的结果，所以i应该从大到小填写。

  // Complexity:
  // TC = O(# of distinct state) * O(# of dependent states to compute one state) * (each calculation time)
  //    = O(n^2) * O(n) * O(1) = O(n^3)



  public int minCost(int[] cuts, int length) {
    // sanity check
    if (cuts == null || cuts.length == 0 || length == 0) {
      return 0;
    }

    // step 1, preprocessing
    // we want put 0 and length into the array [3,4,7], length = 10 ---> [0,3,4,7,10]
    int[] array = new int[cuts.length + 2];
    array[0] = 0;
    for (int i = 0; i < cuts.length; i++) {
      array[i + 1] = cuts[i];
    }
    array[cuts.length + 1] = length;

    // step 2, dp
    // minCost[i][j] = dp(i,j) = the min cost of cutting the partition(i,j) into required segments.
    int[][] minCost = new int[array.length][array.length];
    for (int j = 1; j < array.length; j++) { // j是end position，从第一个可切割位置，到木板的结尾位置
      for (int i = j - 1; i >= 0; i--) { // i是start position，从木板开始的位置，到j前面一个的位置 (由于依赖于k而且k>i, 所以采取倒着求值的方案)
        if (i + 1 == j) { // base rule: adjacent --> 0， 这也是k不存在的情况
          minCost[i][j] = 0;
        } else {          // induction rule: dp(i,j) = thisCutCost + min{furtherCutCosts},   不可能没有k，所以可以将minFurtherCutCosts初始化为MAX_VALUER
          int thisCutCost = array[j] - array[i];
          int minFurtherCutCost = Integer.MAX_VALUE;
          for (int k = i + 1; k <= j - 1; k++) { // since i and j are not adjacent, it's bound to enter this for-loop when filling the upper-right delta area of matrix minCost.
            minFurtherCutCost = Math.min(minFurtherCutCost, minCost[i][k] + minCost[k][j]);
          }
          minCost[i][j] = thisCutCost + minFurtherCutCost;
        }
      }
    }

    // step 3, return the result
    // the result is minCost[0][array.length - 1], which is the largest size problem
    return minCost[0][array.length - 1];
  }
}
