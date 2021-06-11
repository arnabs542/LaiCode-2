package com.study.algorithms.class11_DP_1.重听;

public class DictionaryWord {
    // bobcat

    // outer loop: i [1,n] 这次可以包括不切的情况
    // b | obcat
    // bo | bcat
    // ...
    // bobcat |

    // inner loop:
    // to bo:
    //   bo         itself
    //   b|o        many cases, j [1, i-1]

    // 三部曲：
    // Dict[i] --> 记录前i个字母是否是字典能拼出来的
    // base rule: 递归不会切到这里，但是可能突然访问，所以设置Dict[0] = T
    // induction rule: 如果左边有那么一种方法能break down成word，且右边是一个word。那么第i个元素是T                                    i [1,n]
    //                  左边的方法是，先查不cut是不是word，然后尝试在第j个字母后切一刀，左边拿Dict，右边检查是否是word（右边新增了一个字母）。  j [1,i-1]  由于after i，而i从1开始，所以永远不会去查Dict[0]
    //                 if left seg can be broken down into words && right seg is a word --> first i elements marked as T
    //                      the options to cut down left seg: don't cut, or cut after j[1,i-1] and check Dict[j]&&InSet(sub right)

    // substring函数： endIndex exclusive

    public boolean canBreak(String input, String[] dict) {
        boolean[] Dict = new boolean[input.length() + 1];

    }
}
