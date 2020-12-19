package com.study.algorithms.class06_DFS;

import java.util.ArrayList;
import java.util.List;

public class PermutationsI {
    // DFS solution - with swap
    // High level:
    // we have three level in this case, each level represents a position
    // the number of branches of a node is the number of remaining unused letters
    // for instance, if we are on the i-th level, then we can try (n-i) branches
    //                         root
    //                  /        |      \
    // L1    a bc               b ac             c ba
    //      /   \               /  \             /    \
    // L2 ab c   ac b        ba c   bc a      cb a     ca b          -    n!
    //     |      |           |       |        |         |
    // L3 abc    acb         bac    bca       cba      cab

    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        // sanity check
        if (set == null) {
            return result;
        }
        // change to char array to swap easily
        char[] array = set.toCharArray();
        helper(array, 0, result); // call a helper to solve it recursively.
        return result;
    }
    // How to explain "index":
    //   choose the charactor to be at the position of "index"
    //     all the already chosen positions are [0, index-1]
    //     all the candidate character can be at position index are in the [index, array.length-1]
    public void helper(char[] array, int index, List<String> result) {
        // base case:
        //   when we have already chosen the characters for all the position,(index == array.length)
        //   we can have a complete permutation, and add it into result(a deep copy)
        if (index == array.length) { // when each position hold a character
            result.add(new String(array)); // deep copy, new object
            return;
        }
        // recursion rule:
        // for each remaining unused letters
        for (int i = index; i < array.length; i++) {
            // place it into index (swap), and have a try:
            swap(array, index, i);
            helper(array, index + 1, result);
            // after this helper's return, we need to restore the array for next loop
            swap(array, i, index);
        }
        // How to explain why i starts from index:
        //   all the possible characters (that will be placed at index to have a try) are
        //   the characters in the subarray [index, array.length - 1]
        //   Therefore, i starts from index
    }
    private void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    // complexity:
    // the last two levels of the tree dominate the overall cost:
    // so the time complexity is O(n!) where n is the number of letters in the string
    // the space complexity is O(n!*n + n) = O(n!)
}
