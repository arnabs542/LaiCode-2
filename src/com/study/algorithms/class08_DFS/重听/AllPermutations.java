package com.study.algorithms.class08_DFS.重听;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
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

    // Complexity:
    //  time: O(n!) --> dominant factor
    //  space: O(n)
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        // change to char array to swap easily
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }
    // How to explain "index":
    //   choose the char to be at the position of "index"
    //     all the already chosen positions are [0, index-1]
    //     all the candidate character can be at position index are in the [index, array.length-1]
    private void helper(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }

        for (int j = index; j < array.length; j++) {
            // 从理论上，j可以从index+1开始，
            // 但是那样会漏掉一个分支，即不交换的那个分支。
            // 同时，还会在最后一层（只剩下一个元素可选）漏掉递归调用的base case，产出[]（如果其他逻辑不变）
            swap(array, index, j);
            helper(array, index + 1, result);
            swap(array, index, j);
        }
    }

    // How to explain why i starts from index:
    //   all the possible characters (that will be placed at index to have a try) are
    //   the characters in the subarray [index, array.length - 1]
    //   Therefore, i starts from index
    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
