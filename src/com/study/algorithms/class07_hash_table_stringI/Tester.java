package com.study.algorithms.class07_hash_table_stringI;

import java.util.Arrays;
import java.util.List;

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

        System.out.println("Common Number in Tow Sorted Arrays");
        CommonNumbersII common = new CommonNumbersII();
        int[] a = new int[]{0,0,3,4,6,7,8,10,10,10,10,11,11,12,15,21,21,24,24,24,24};
        int[] b = new int[]{1,1,1,1,1,2,4,4,7,7,9,13,13,13,18,21,21,23,23,24,24};
        List<Integer> res1 = common.commonI(a, b);
        List<Integer> res2 = common.commonII(a, b);
        System.out.println(res1.toString()); // hash map cannot assure the relative order, so it won't pass online judge, but still correct.
        System.out.println(res2.toString());
    }
}
