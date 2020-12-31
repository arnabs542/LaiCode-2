package com.study.algorithms.class11_DP_1;

public class ArrayHopperI {
  /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your  maximum  jump length at that position.
    Determine if you are able to reach the last index.
  * */
  public boolean canJump(int[] array) {
    // sanity check: (Assumption, array is not null and is not empty)
    if (array.length == 1) {
      return true;
    }

    // canJump[i]  -->  means from index i can jump to the last position
    // base case:       last position can jump to itself. canJump[array.length - 1] = true
    // induction rule:  try 0 to array[i] cases in each position, check if it possible to jump to a true position
    boolean[] canJump = new boolean[array.length];
    canJump[array.length - 1] = true;
    for (int i = array.length - 2; i >= 0; i--) {
      canJump[i] = false;
      // case 1: if from i, can jump to the end directly
      if (i + array[i] >= array.length - 1) {
        canJump[i] = true;
      } else {
        // case 2: if from i, can jump to a true position (intermediate position)
        // check if from index i it is possible to jump to a true position (to end)
        for (int j = 1; j <= array[i]; j++) {
          // try to jump to each reachable position j[0, array[i]]
          if (canJump[i + j]) { // no need to check if i + j is valid. if not valid, it falls into case 1.
            canJump[i] = true;
            break;
          }
        }
      }
    }
    return canJump[0];
  }

}
