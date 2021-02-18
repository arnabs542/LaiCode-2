package com.study.algorithms.finalexam;

public class question3 {
  // put swags into square-shaped boxes
  // Given the number of swags, what is the minimum number of boxes to pack them up?

  // DP
  // M[i] represents the min boxes number to pack up i swags.
  // base rule: 1 swag -> 1 box
  // induction rule:
  //    M[i] = 1, if i is a square number.
  //    M[i] = min{ M[i-k] + 1 | 1 <= k <= i-1 and k is a square number}, else

  private boolean isSquareNumber(int num) {
    for (int i = 1; i <= num; i++) {
      if (i * i == num) {
        return true;
      }
    }
    return false;
  }

  public int minBoxes(int swags) {
    // input number of swags, output minNumber of boxes
    int[] M = new int[swags + 1];
    // base rule:
    M[0] = 0;
    M[1] = 1;
    // induction rule:
    for (int i = 2; i <= swags; i++) {
      M[i] = i;
      if (isSquareNumber(i)) { // case 1
        M[i] = 1;
      } else { // case 2
        int min = Integer.MAX_VALUE;
        for (int k = 1; k <= i - 1; k++) {
          if (isSquareNumber(k)) {
            min = Math.min(min, M[i - k] + 1);
          }
        }
        M[i] = min;
      }
    }
    return M[swags];
  }

}
