package com.study.algorithms.class22_DP_4;

public class CuttingWoodII {
  public int minCost(int[] cuts, int length) {
    // Assumptions: cuts is not null, length >= 0, all cuts are valid numbers.

    // Step 1: [2,4,7], length = 10 --> [0,2,4,7,10] (depends on the input)
    // so that we put all information into one array.
    int[] array = new int[cuts.length + 2];
    array[0] = 0;
    for (int i = 0; i < cuts.length; i++) {
      array[i + 1] = cuts[i];
    }
    array[array.length - 1] = length;

    // Step 2: DP
    // minCost[i][j]: the min cost of cutting the partition(i,j).
    int[][] minCost = new int[array.length][array.length];
    for (int j = 1; j < array.length; j++) { // the end of a partition
      for (int i = j - 1; i >= 0; i--) {     // different start position
        if (i + 1 == j) { // base rule: adjacent
          minCost[i][j] = 0;
        } else {          // induction rule: dp(i,j) = (a[j]-a[i] + min(dp(i,k) + dp(k,j))
          int minFurtherCost = Integer.MAX_VALUE; // cost for all further cuts.
          int thisCutCost = array[j] - array[i]; // cost for this cut.
          for (int k = i + 1; k <= j - 1; k++) {
            minFurtherCost = Math.min(minFurtherCost, minCost[i][k] + minCost[k][j]);
          }
          minCost[i][j] = thisCutCost + minFurtherCost; // minimum cost to cut [i,j] into required segments.
        }
      }
    }
    return minCost[0][array.length - 1];
  }
}
