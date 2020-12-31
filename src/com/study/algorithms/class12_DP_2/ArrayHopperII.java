package com.study.algorithms.class12_DP_2;

public class ArrayHopperII {
  // ArrayHopperI --> tell me whether or not can jump to the end position from the 0-th position
  // ArrayHopperII --> also want know the minimum jumps needed.

  // Recap ArrayHopper I
  // A {3, 3, 1, 0, 4}
  // M  T  T  F  F  T
  // M: ith element represents whether A[i] can jump to A[n-1] or not
  // base case: M n-1 is true
  // induction rule: M[i] = true if M[i] ... M[i + A[i]] have a true
  //                 M[i] = OR(M[i] ... M[i + A[i]])
  public boolean canJump(int[] A) {
    // Assumption: A is not null and not empty
    boolean[] canJump = new boolean[A.length];
    canJump[A.length - 1] = true;
    for (int i = A.length - 2; i >= 0; i--) {
      // i represents the ith element in A.
      canJump[i] = false;
      if (i + A[i] >= A.length - 1) { // NOTICE: 总是忘记这个情况。
        // case 1 jump to/over end directly
        canJump[i] = true;
        continue;
      }
      for (int j = 1; j <= A[i]; j++) {
        // case 2: jump to a true position
        // j represents a distance that can be jump to from i-th element
        if (canJump[i + j]) {
          canJump[i] = true;
          break;
        }
      }
    }
    return canJump[0];
  }

  // ArrayHooper II
  // A {3, 3, 1, 0, 4}
  // M  2  1 -1 -1  0
  public int minJump(int[] array) {
    // minJump[i] represents the min step array[i] needs to take to jump to the end
    // base rule: minJump[n-1] = 0
    // induction rule: minJump = MIN(minJump[i], minJump[i + A[i]]) + 1;
    int[] minJump = new int[array.length];
    // base rule: last item is 0
    minJump[array.length - 1] = 0;
    for (int i = array.length - 2; i >= 0; i--) {
      // case 1: array[i] can jump to end directly
      if (array[i] + i >= array.length - 1) {
        minJump[i] = 1;
        continue;
      }
      // case 2: array[i] can jump to a true position
      // try different reachable position
      int minSteps = Integer.MAX_VALUE;
      for (int j = 1; j <= array[i]; j++) {
        if (minJump[i + j] != 0) {
          minJump[i] = Math.min(minJump[i + j] + 1, minSteps);
        }
      }
      // case 3: array[i] cannot jump to a true position. -- default 0
    }
    return minJump[0];
  }


}
