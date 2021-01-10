package com.study.algorithms.class08_stringII;

public class ReorderString {
  // 逆过程，以前有一个mergeSort思路的 abc123 -> a1b2c3
  // 这里是 a1b2c3 -> a1b2 | c3 -> ab12 c3 -> abc123

  // use I love yahoo trick here


  // { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
  // { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
    /*
    * 这个题和 ABCD1234 -> A1B2C3D4 是一样的。只是不用字母罢了
    *
    * 1. merge sort with letter 的recursion tree
    *
    *                A1B2C3D4
    *           A1B2          C3D4
    *        A1     B2      C3     D4
    *        A 1   B 2     C 3   D 4
    *       ------------------------
    *        A1   B2      C3    D4
    *         AB12         CD34
    *         i j
    *             ABCD1234
    *
    * 2. reverse engineering
    *
    *         ABCD 1234
    *           -- --             AB (CD 12) 34 --> AB (12 CD) 34, i love yahoo trick.
    *      AB12     CD34
    *     A1 B2     C3 D4
    *   -------------------
    *     A1B2      C3D4
    *       A1B2C3D4
    *
    * 3. 再换成用下标表示：
    *       1234 5678
    *         -- --         (34 56) -> (56 34)
    *     1256     3478
    *      --       --         (2,5) -> (5,2);   (4,7) -> (7,4)
    *    15  26    37  48
    * ---------------------
    *    1526      3748
    *      15263748
    *
    * 4. 再编写一个奇数个数的例子 （关键）
    *
    *           123 456 7
    *            -- -        --> (21,4) 要求23的个数和56的个数相同，不然无法继续执行
    *          14    2356         7
    *          14    25 36        7
    *          ----------------------
    *          1425   357
    *          1425367
    * */

  public int[] reorder(int[] array) {
    // sanity check
    if (array == null) {
      return array;
    }
    // 注意1：考虑奇偶性, 不然N2k+1不会停留在结尾：
    if (array.length % 2 == 0) {
      reorder(array, 0, array.length - 1);
    } else {
      reorder(array, 0, array.length - 2);
    }
    return array;
  }

  private void reorder(int[] array, int left, int right) {
    // base case:
    if (right - left <= 1) { // 注意3： 不要用left == right 和 left - right <= 1 都可以。
      // 尽管==不会让0,1变成1,0,因为lmid和rmid-1会都是0 --> length = 2, mid = 1, lmid = 0, rmid = 1.   reverse(array, lmid, rmid-1)
      // 但是这个对corner case就失效了：比如只有一个元素，那么right = -1, left = 0. 如果外面的sanity check没写好。这里不拦下来后面就崩了。

      // 注意4：两个元素的情况下：right - left = 1 而不是等于2.
      return;
    }
    // recursion rule:
    // step1: shuffle, using I Love Yahoo trick
    int length = right - left + 1; // 技巧，用长度来计算index。不然很麻烦。
    int mid = left + length / 2; // 由于已经确保总长度和每一次的length都是偶数，所以可以这样做 // 注意5：但是不能保证 /4 也是整数。所以不能/4
    int lmid = left + length / 4;
    int rmid = mid + length / 4;
    // index 0 1 2 3 4 5
    // value 1 2 3 4 5 6
    //       - --- - ---
    //         l   m r
    // mid = 0 + 3 --> 3
    // lmid = 0 + 1 --> 1   left part: 23
    // rmid = 3 + 1 --> 4   right part: 4
    reverse(array, lmid, mid - 1); // 12  DC
    reverse(array, mid, rmid - 1); // 12  CD
    reverse(array, lmid, rmid - 1); // 注意4：i love yahoo trick. 先word再整体


    // step2: solve sub problems,
    // 注意2：这里两边不一定一样长。以6个elemetns的为例子：可能左边是14，右边是2356.为了保证都是偶数，就会不一样长。
    // 而不是 left + (right - left) / 2 那样的左侧结尾，
    // 所以应该mid-1
    reorder(array, left, left + 2 * (lmid - left) - 1);
    reorder(array, left + 2 * (lmid - left), right);

    // step3: merge, auto do this, since inplace.
  }


  // 这是我重新写的 第三遍练习的版本：
  public int[] reorderArray(int[] input) {
    // input an integer array
    // output another array:
    //  { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k } even
    //  { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 } odd

    // split and merge
    //  1234567
    //  123456   7
    //   / \
    //  14 2356 <-- subproblem (even number of elements)
    //   |  / \
    //  14  25 36
    // --------------
    //  14  2536
    //  142536
    // O(log2n) levels -- O(n) --> O(nlog2n)

    if (input.length % 2 == 0) {
      helper(input, 0, input.length - 1);
    } else {
      helper(input, 0, input.length - 2);
    }
    return input;
  }

  // recursive function
  void helper(int[] input, int left, int right) {
    // base case:
    while (right - left <= 1) {
      return;
    }
    // recursion rule:              c1  c2   c3  c4
    // 1. split them:    123456 -> (1) (23) (4) (56)
    //                                  l    m   r
    // 2. reverse the    (1) (23) (4) (56) -> (1)(4)  (23)(56)
    // 3. recursion call: solve(14) and (2356)

    int length = right - left + 1;
    int mid = left + length / 2;
    int lmid = left + length / 4;
    int rmid = mid + length / 4; // the 1st and 3rd chunk should have same size.

    reverse(input, lmid, mid - 1);
    reverse(input, mid, rmid - 1);
    reverse(input, lmid, rmid - 1);

    helper(input, left, left + (lmid - left) * 2 - 1); // size of it is the double length of chunk 1
    helper(input, left + (lmid - left) * 2, right);
  }

  private void reverse(int[] array, int i, int j) {
    while (i < j) {
      swap(array, i, j);
      i++;
      j--;
    }
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
