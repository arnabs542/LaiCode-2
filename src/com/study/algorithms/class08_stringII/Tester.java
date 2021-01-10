package com.study.algorithms.class08_stringII;

import java.util.Arrays;
import java.util.List;

public class Tester {

  public static void main(String[] args) {
    ReverseWords rw = new ReverseWords();
    String str = "I love Yahoo";
    System.out.println(rw.reverseWords(str));

    RightShift rs = new RightShift();
    String str2 = "abcdef";
    System.out.println(rs.rightShift(str2, 2));

    StringReplace sr = new StringReplace();
    String input = "laicode";
    String source = "code";
    String target = "offer";
    System.out.println(sr.replace(input, source, target));

    PermutationsII p = new PermutationsII();
    String string = "abb";
    List<String> results = p.permutations(string);
    System.out.println(results);

    ReorderString reorder = new ReorderString();
    int[] array = new int[]{1,2,3,4,5,6,7};
    System.out.println(Arrays.toString(reorder.reorderArray(array)));
  }
}
