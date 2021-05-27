package com.study.algorithms.class08_DFS.重听;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllValidPermutationsOfParentheses {
    // Given N pairs of parentheses “()”, return a list with all the valid permutations.
    // Assumptions
    //    N > 0
    // Examples
    //    N = 1, all valid permutations are ["()"]
    //    N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

    // C: input:
    //    n -> pair number, n > 0
    //    output:
    //    list of string

    //       {}
    //      /  \
    //     (   x
    //     / \
    //    ((     ()
    //    /\      /\
    //  ((  (()  ()(  x
    //   /\   /\   /\
    // ((( (()  (()(  (())  ()(  ()()
    // 1. cannot exceed n
    // 2. left > right parenthesis

    // dfs: each level: try add left or right
    // # of levels: 2n

    // tc: O(2^(2n))
    // sc: O(2n) - 只计算 buffer, 不计算输出空间

    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        char[] buffer = new char[2 * n];
        helper(n, 0, 0, buffer, 0, result);
        return result;
    }

    private void helper(int n, int left, int right, char[] buffer, int index, List<String> result) {
        if (left == n && right == n) {
            result.add(new String(buffer));
            return;
        }
        // case 1: add left -- left < n
        if (left < n) {  // left 不可能超过n，因为left++ 必须在 left < n 中才会调用。极端情况为 == n
            buffer[index] = '(';
            helper(n, left + 1, right, buffer, index + 1, result);
        }

        // case 2: add right -- right < left
        if (right < left) {  // right 不可能超过left，因为right++ 必须在 right < left 中才会调用。极端情况为 == left
            buffer[index] = ')';
            helper(n, left, right + 1, buffer, index + 1, result);
        }
    }
}





