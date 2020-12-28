package com.study.algorithms.class12_DP_2;

import java.util.Set;

import static com.study.util.ToSet.toSet;

public class DictionaryWord {
    // input:           dict (array of string), string
    // output:          true or false
    // base rule:       empty string is true (choose no word from dict is empty)
    // induction rule:
    //          try to cut in different location
    //               left | right
    //          for left, check in previous record
    //          for right, check in dictionary

    public boolean canBreak(String input, String[] dict) {
        Set<String> dictSet = toSet(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true; // canBreak[i] represents first i characters in input can break or not.
        for (int i = 1; i <= input.length(); i++) {
            // i represents first i letters in the input string
            for (int j = 0; j < i; j++) {
                // j represents first j letters in the input string belongs to left part -- e.g. in "b"|"ob", j is 1.
                if (canBreak[j] && dictSet.contains(input.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[input.length()];
    }
}
