package com.study.algorithms.class07_DFS;

class TestCases {
  public void testPermutationsI() {
    PermutationsI permutationsI = new PermutationsI();
    System.out.println(permutationsI.permutations("abcd"));
  }

  public void testCombinationsOfCoins() {
    CombinationsOfCoins combinations = new CombinationsOfCoins();
    System.out.println(combinations.combinations(99, new int[]{25, 10, 5, 1}));
  }

  public void testSubSetsI() {
    SubSetsI subSetsI = new SubSetsI();
    System.out.println(subSetsI.subSets("abcd"));
  }

  public void testValidParentheses() {
    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(validParentheses.validParentheses(3));
  }
}
