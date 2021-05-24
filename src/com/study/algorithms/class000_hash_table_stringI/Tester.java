package com.study.algorithms.class000_hash_table_stringI;

import java.util.Arrays;
import java.util.List;

public class Tester {
  public static void main(String[] args) {
    System.out.println("Top K Frequent:");
    TopKFrequent topK = new TopKFrequent();
    String[] combo = new String[]{"d", "a", "c", "b", "d", "a", "b", "b", "a", "d", "d", "a", "d"};
    String[] result = topK.topKFrequent(combo, 2);
    System.out.println(Arrays.toString(result));

    System.out.println("Missing Number: (return N is no missing)");
    MissingNumberI m = new MissingNumberI();
    int[] nums = new int[]{1, 9, 5, 4, 8, 7, 2, 3}; // missing 6, N = 9 (1-9)
    System.out.println(m.missingI(nums));
    System.out.println(m.missingII(nums));
    System.out.println(m.missingIII(nums));

    System.out.println("Common Number in Tow Sorted Arrays");
    CommonNumbersII common = new CommonNumbersII();
    int[] a = new int[]{0, 0, 3, 4, 6, 7, 8, 10, 10, 10, 10, 11, 11, 12, 15, 21, 21, 24, 24, 24, 24};
    int[] b = new int[]{1, 1, 1, 1, 1, 2, 4, 4, 7, 7, 9, 13, 13, 13, 18, 21, 21, 23, 23, 24, 24};
    List<Integer> res1 = common.commonI(a, b);
    List<Integer> res2 = common.commonII(a, b);
    System.out.println(res1.toString()); // hash map cannot assure the relative order, so it won't pass online judge, but still correct.
    System.out.println(res2.toString());

    System.out.println("----Char Removal----");
    RemoveCertainCharacters remove1 = new RemoveCertainCharacters();
    String input = "student";
    String t = "un";
    System.out.println(remove1.remove(input, t));

    RemoveSpaces remove2 = new RemoveSpaces();
    String input2 = "  an   apple       ";
    System.out.println(remove2.removeSpaces(input2));

    System.out.println("----Deduplicate----");
    Deduplicate dedup1 = new Deduplicate();
    String str1 = "aabbbcc";
    System.out.println(str1 + " -> " + dedup1.deDup(str1));

    DeduplicateRepeatedly dedup2 = new DeduplicateRepeatedly();
    System.out.println(str1 + " -> " + dedup2.deDup(str1));

    System.out.println("----Sub-String----");
    Strstr strstr = new Strstr();
    String large = "遇到了一只小猫咪";
    String small = "一只小猫咪";
    System.out.println(strstr.strstrI(large, small));
    System.out.println(strstr.strstrII(large, small));
    System.out.println(strstr.strstrIII(large, small));
  }
}
