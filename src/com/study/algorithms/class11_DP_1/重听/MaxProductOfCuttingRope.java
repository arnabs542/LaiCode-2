package com.study.algorithms.class11_DP_1.重听;

public class MaxProductOfCuttingRope {

    // 左大段 + 右小段：右小段不分割，左大段可以分也可以部分


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
    public int maxProductR(int length) {      //  带有问题的代码 -->  会有很多重复的内容  --> 用左大段右小段可以解决
        // each level stands for a cut
        // each branch stands for a cut case
        // _|___                // 问题1，漏了考虑"左侧不进一步分割"的情况
        //      _ | __|_        // 问题2，重复
        //      _ | _|__
        // __|__
        //      _|_ | _|_
        // ___|_
        //      _|__ | _
        //      __|_ | _
        if (length <= 1) {
            return length;
        }
        // try different cases
        // i --> we will cut after i-th meter
        int globalMax = Integer.MIN_VALUE;
        for (int i = 1; i <= length - 1; i++) { // 漏了考虑不进一步分割的情况
            int cur = maxProductR(i) * maxProductR(length - i);   //  带有问题的代码 -->  会有很多重复的内容  --> 用左大段右小段可以解决
            globalMax = Math.max(globalMax, cur);
        }
        return globalMax;
    }

    public int maxProductR2(int length) {
        // each level stands for a cut
        // each branch stands for a cut case, right part cannot be divided further.
        // _|___
        //      _|___      --> right part cannot be divided further. 防止大量重复内容
        //
        // __|__
        //      __  | __
        //      _|_ | __
        // ___|_
        //      ___  | _
        //      _|__ | _
        //      __|_ | _
        if (length <= 1) {
            return 0; // 1不能继续分
        }
        // try different cases
        // i --> we will cut after i-th meter
        int globalMax = Integer.MIN_VALUE;
        for (int i = 1; i <= length - 1; i++) {
            int subBest = Math.max(maxProductR2(i), i); //  左大段在各种切分中选一个最好的（包括不分割），比如2如果分成1，1那么1x1小于2，就不该分
            int cur = subBest * (length - i);           //  右小段不分割
            globalMax = Math.max(globalMax, cur);
        }
        return globalMax;
    }
    // Time: O(n!)
    // Space: O(n) --> laicode上会time out，因为递归太多了。

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

    // 三部曲：
    // 表格物理意义： M[i] stores the maxProduct of i meter ropes, i stands for i-th element in the rope. or first i elements.
    // base rule:  M[0] = 0, M[1] = 0, 他俩invalid，不能继续再分。
    // induction rule: 左大段，右小段
    //                 case: don't cut （invalid in this problem)
    //                 case: cut
    //                      cut after j-th --> try j [1,i-1]
    //                      left seg: [1,j-1]  can divide or not divide, get Max(j, M[j])
    //                      right seg: [j,i]  don't divide it --> means get it value directly
    //
    public int maxProduct(int length) {
        int[] M = new int[length + 1];
        // base rule:
        M[0] = 0;
        M[1] = 0;

        // induction rule:
        for (int i = 2; i <= length; i++) {     // I want get i-th result
            int maxProduct = 0;
            for (int j = 1; j <= i - 1; j++) {  // I try to cut after j-th element
                int subBest = Math.max(j, M[j]) * (i - j);
                maxProduct = Math.max(subBest, maxProduct);
            }
            M[i] = maxProduct;
        }
        return M[length];
    }
    // Time: O(n^2)     从 n! --> n^2 了
    // Space: O(n)      但是不再在call stack上了，会更好
}
