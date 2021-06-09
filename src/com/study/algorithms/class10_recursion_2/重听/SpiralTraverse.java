package com.study.algorithms.class10_recursion_2.重听;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    // 螺旋形打印, offset + side length
    // base case 分奇偶数
    // matrix is not null, and side length >= 0
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int offset = 0;
        int height = matrix.length; // height = # of rows
        int width = matrix[0].length; // width = # of cols
        while (height > 0 && width > 0) {
            // base case
            if (height == 1) {
                for (int i = 0; i < width; i++) {
                    res.add(matrix[offset][offset + i]);
                }
                return res;
            }
            if (width == 1) {
                for (int i = 0; i < height; i++) {
                    res.add(matrix[offset + i][offset]);
                }
                return res;
            }

            // iteration rule:
            for (int i = 0; i < width - 1; i++) {
                res.add(matrix[offset][offset + i]);
            }
            for (int i = 0; i < height - 1; i++) {
                res.add(matrix[offset + i][offset + width - 1]);
            }
            for (int i = width - 1; i > 0; i--) {
                res.add(matrix[offset + height - 1][offset + i]);
            }
            for (int i = height - 1; i > 0; i--) {
                res.add(matrix[offset + i][offset]);
            }

            // change
            height -= 2;
            width -= 2;
            offset++;
        }
        return res;
    }

    // time: O(M*N)
    // space: O(1)
}
