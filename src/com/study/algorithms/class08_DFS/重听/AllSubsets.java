package com.study.algorithms.class08_DFS.重听;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllSubsets {
//    Given a set of characters represented by a String, return a list containing all subsets of the characters.
// Assumptions
//    There are no duplicate characters in the original set.
// Examples
//    Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
//    Set = "", all the subsets are [""]
//    Set = null, all the subsets are []

    //      {}
    //   {a} {}
    //{ab} {a} {b} {}
    //

    // each level: try or not try a letter

    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        StringBuilder prefix = new StringBuilder(); // record the current subset
        helper(set, 0, prefix, result);
        return result;
    }

    private void helper(String set, int index, StringBuilder prefix, List<String> result) {
        // leaf: index == 3 (out of bound)
        // after deciding pick or not pick each char, we get one complete subset.
        if (index == set.length()) {
            result.add(prefix.toString());
            return;
        }

        // this level:
        prefix.append(set.charAt(index));
        helper(set, index + 1, prefix, result); // case 1: pick the char at index
        prefix.deleteCharAt(prefix.length() - 1);
        helper(set, index + 1, prefix, result); // case 2: do not pick
    }
    // Time: O(2^n * n) n 可能来自result.add, 最后一层最多2^n
    // Space: 如果不计算output，直接打印了，那就是O(n)
}
