package com.study.algorithms.class12_DP_2;

public class EditDistance {
    public int editDistanceRecursion(String word1, String word2) {
        // Recursive way to solve this problem
        //          (asdf, sghj)
        //          /     |      \                  --> three branches: replace, delete, insert, only operate word one
        // (sdf,ghj)  (sdf,sghj) (asdf, ghj)
        // a->s       asdf->sdf    asdf->sasdf
        // ...

        // TC: Time = O(3^(m+n))  3 branches each level, m+n levels at most. Do not use .substring which needs O(n+m) in each level

        // base case: one or two is empty, return the length of remaining part
        // recursion rule: try each branches to get their # of operations, return the minimum.

        // I want use index instead of substring.
        return helper(word1, word2, 0, 0);
    }

    private int helper(String word1, String word2, int index1, int index2) {
        // base case:
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }

//        corner case: similar initial letter
//        这样写是错的，因为index++以后，不能保证还在有效范围内。
//        更好的方法是return的值不+1。
//        为此可以把return的+1分派到三个case里负责，replace这个case的+1取决于是否相同首字母。
//        if (word1.charAt(index1) == word2.charAt(index2)) {
//            index1++;
//            index2++;
//        }
        // get operations of 3 cases:
        int replace = helper(word1, word2, index1 + 1, index2 + 1) + (word1.charAt(index1) == word2.charAt(index2) ? 0 : 1);
        int insert = helper(word1, word2, index1 + 1, index2) + 1;
        int delete = helper(word1, word2, index1, index2 + 1) + 1;
        // construct the solution of this level
        return Math.min(Math.min(replace, insert), delete);
    }


    public int editDistance(String one, String two) {
        // Assumption: one, two are not null

        // Meaning:
        // i、j分别代表one、two第x个字母开始的子串。和recursion方法中的index1与index2含义相同。
        // distance[i][j] represents # of operations to convert one.substring(i) to two.substring(j).
        // distance[0][0]: original problem: "asdf" and "sghj"
        // distance[0][1]: # of operations between "asdf" and "ghj"
        // distance[4][4]: # of operations between "" and ""


        // base rule: one of them is empty, edit distance is # of letters.
        //      when i = one.length, distance[i][j] = two.substring(i).length = two.length - i
        //      when j = two.length, distance[i][j] = one.substring(j).length = one.length - j

        // induction rule: 选择当前问题下三种方案中的最小值（查表），然后填写当前单元格。
        //      distance[i][j] = MIN(right, bottom, bottomRight) + cost of current operation(1 or 0)
        //                  ”左“大段                          “右小段”

        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = one.length(); i >= 0; i--) {
            for (int j = two.length(); j >= 0; j--) {
                // base cases:
                if (i == one.length()) {
                    distance[i][j] = two.length() - j;
                } else if (j == two.length()) {
                    distance[i][j] = one.length() - i;
                } else {
                    // induction rule:
                    int replace = distance[i + 1][j + 1] + (one.charAt(i) == two.charAt(j) ? 0 : 1);
                    int insert = distance[i + 1][j] + 1;
                    int delete = distance[i][j + 1] + 1;
                    distance[i][j] = Math.min(Math.min(replace, insert), delete);
                }
            }
        }
        return distance[0][0];
    }
}
