package com.study.project_final;
// 设有N堆沙子排成一排，其编号为1,2,3,...,N(N<=100)。
//   每堆沙子有一定的数量。现要将N堆沙子并成为一堆。
//   归并的过程只能每次将相邻的两堆沙子堆成一堆（每次合并花费的代价为当前两堆沙子的总数量），
// 这样经过N-1次归并后成为一堆，归并的总代价为每次合并花费的代价和。
// 找出一种合理的归并方法，使总的代价最小。

// 例如：有3堆沙子，数量分别为13,7,8，有两种合并方案。
//   第一种方案：先合并1,2号堆，合并后的新堆沙子数量为20，本次合并代价为20，
//      再拿新堆与第3堆沙子合并，合并后的沙子数量为28，本次合并代价为28，
//      将3堆沙子合并到一起的总代价为第一次合并代价20加上第二次合并代价28，即48；
//   第二种方案：先合并2,3号堆，合并后的新堆沙子数量为15，本次合并代价为15，
//      再拿新堆与第1堆沙子合并，合并后的沙子数量为28，本次合并代价为28，
//      将3堆沙子合并到一起的总代价为第一次合并代价15加上第二次合并代价28，即43；
// 采用第二种方案可取得最小总代价，值为43。

// LeetCode merge stones.
// https://leetcode.com/problems/minimum-cost-to-merge-stones/

// 假设：
// 1. n piles of sands --> an int array

// solution: DP 切木头修改版：当次开销的计算方式是SUM(input[i]...input[j])
// 1. Base case: M[i][i] = 0
//               M[i][i+1] = Input[i] + input[i+1]
// 2. Induction Rule:
//    M[i][j] represents the min cost of merging all sands from index i to index j
//                      k
//      xxxxxxxxxxXxxxxxxxxxxxxxxYxxxxxx
//		            i		           j
//    M[i][j] =  min(M[i][k] + M[k+1][j]) + SUM(input[i]...input[j])
//		             cost of left/right 大段     cost of 本次
//                 是子问题                    是把第i堆到第j堆的value加起来，相当于是“合并后的i和j相加”

public class MergeNPilesOfSands {
  // input: int[] sands, int K
  // output: int (min cost)

  // M[i][j] --> the min cost to merge {i, i+1, ... j} piles of sands
  public int mergeSands(int[] sands, int K) { // 先假设K=2的情况，即一次只能合并两堆，这是期末考试的题目。stones题目则是要求一次最多合并K个来求cost。
    int[][] M = new int[sands.length][sands.length];
    // i < k < j, so we need to fill [i+1][j] before we fill [i][j]
    for (int j = 1; j < sands.length; j++) { // j is the end position
      for (int i = j - 1; i >= 0; i--) { // i is the start position, we fill it from large to small
        if (i + 1 == j) { // base rule
          M[i][j] = sands[i] + sands[j];
        } else { // induction rule
          // min cost of merging sands into K piles, each one is a subproblem
          int minSubProblemCost = Integer.MAX_VALUE;
          for (int k = i; k <= j - 1; k++) {
            minSubProblemCost = Math.min(minSubProblemCost, M[i][k] + M[k + 1][j]); // M[j][j] == 0
          }

          // cost of merging these K piles of sands
          int thisProblemCost = 0;
          for (int m = i; m <= j; m++) {
            thisProblemCost += sands[m];
          }

          M[i][j] = thisProblemCost + minSubProblemCost;
        }
      }
    }
    return M[0][sands.length - 1];
  }
}
