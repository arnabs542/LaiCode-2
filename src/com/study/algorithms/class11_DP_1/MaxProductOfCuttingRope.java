package com.study.algorithms.class11_DP_1;

public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // 左大段 + 右小段
        // 如果是按照DFS的方法，那么是如下的情况：
        // Assumption: length >= 2
        // level: stand for once cut
        // branches: try different cases --> and record the max one to put
        /*
        *                   rope == 8m
        * L1(1st cut)
        *           1      2      3   4   5   6   7
        *      rope(7)  rope(6)   ... ...
        *       /|||||\
        * L2(2nd cut)
        *    rope(6) rope(5) ...
        *
        * ...
        * L7
        *   rope(1)
        *
        * 但是，至少切一刀就行了。也就是说，L1开始的left part，可以继续切，也可以不继续切。
        * 每个case都分成两个小case：继续切（回看array），与不继续切（就是自己）。看哪个更大
        * */

        // 用DP的方法，不需要绘制这个tree，应该是画表格 + 举例子
        // index    0   1   2   3   4
        // array    0   1   1   2   4
        // size == 2  case1 _ | _                                     -->1
        //                  1*1 = 1
        // size == 3  case1 _ | __,  case2 __ | _                     -->2
        //                 1 * 2 = 2      1*1 = 2, but (2) * 1 = 2!
        // size == 4 case 1 _ | ___, case2 __ | __, case3 ___ | _     -->4
        //                  1*3            1*2, but(2) *2=4,   2*1, but (3)*1 = 3
        //
        // Time: (n-1) * (n-2) * ... * 1 = O(n!)
        // Space: O(n)

        // 注意每次往回看表格的时候，如果切了的product还没有不切的大，就不切。所以有两个max的过程。

        int[] array = new int[length + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= length; i++) { // [0,i] is the current problem size
            for (int j = 0; j < i; j++) { //[0,j] left part, (j,i] right part
                // different cases
                //  left part maxProduct  *    right part
                int current = Math.max(j, array[j]) * (i - j);
                array[i] = Math.max(array[i], current);
            }
        }
        return array[length];
    }
}
