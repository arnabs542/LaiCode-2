package com.study.algorithms.class12_DP_2;

public class LargestSquareOfOnes {
    public int largest(int[][] matrix) {
        // assumption: the matrix is a binary matrix
        // (binary means that it only contains 0 and 1)
        // it is not null and has size N*N (N > 0)
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int globalMax = 0;
        int[][] largest = new int[N][N];
        // largest[i][j] means the side length of the largest square of 1's
        // with right bottom corner as matrix[i][j]

        // base rule: top row, leftmost column of dp is the same value of matrix
        // induction rule:  dp[i][j] =
        //                  MIN(top, topleft, left) + 1, if 1
        //                  0                          , if 0
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // i --> each rows from left to right
                // j --> each column from top to bottom
                if (i == 0 || j == 0) { // base rule
                    largest[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.min(largest[i][j - 1] + 1, largest[i - 1][j - 1] + 1);
                    largest[i][j] = Math.min(largest[i - 1][j] + 1, largest[i][j]);
                }
                globalMax = Math.max(globalMax, largest[i][j]);
            }
        }
        return globalMax;
    }
}
