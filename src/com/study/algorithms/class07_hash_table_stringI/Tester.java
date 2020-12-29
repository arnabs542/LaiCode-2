package com.study.algorithms.class07_hash_table_stringI;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Top K Frequent:");
        TopKFrequent topK = new TopKFrequent();
        String[] combo = new String[]{"d","a","c","b","d","a","b","b","a","d","d","a","d"};
        String[] result = topK.topKFrequent(combo, 2);
        System.out.println(Arrays.toString(result));

        System.out.println("Missing Number: (return N is no missing)");
        MissingNumberI m = new MissingNumberI();
        int[] nums = new int[]{1,9,5,4,8,7,2,3}; // missing 6, N = 9 (1-9)
        System.out.println(m.missingI(nums));
        System.out.println(m.missingII(nums));
        System.out.println(m.missingIII(nums));
    }
}
