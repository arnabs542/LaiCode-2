package com.study.practice.class09_bit_representation;

public class AllUniqueCharsII {
  // Determine if the characters of a given string are all unique.
  // Assumptions：
  //     use ASCII charset: values from 0 to 255

  public boolean allUnique(String word) {
    if (word == null || word.length() == 0) {
      return true; // no duplicate char. haha
    }
    // each int can represent 32 bit
    // 256 = 8 * 32, so we need 8 int
    int[] vectors = new int[8];
    char[] array = word.toCharArray();
    for (char c : array) {
      int intIndex = c / 32;
      int index = c % 32;
      // if the char already exists:   tester
      if (((vectors[intIndex] >> index) & 1) != 0) {
        return false;
      }
      // otherwise:  setter
      vectors[intIndex] |= 1 << index;
    }
    return true;
  }

}
