package com.study.practice.string_and_integer;

public class IsNumericII {
  // handle signs and scientific expression
  /*
   * "2.0e-10"     --> true
   * "2.0e+10"     --> true
   *
   * "2e"          --> false  e后面要有一个次方数
   * 2e.4"         --> false  e后面只能是整数，不可以是小数
   *
   * “”            --> false  本题认为"" 是错的
   * */

  // what we expect:
  // '0'-'9', '.', 'e', 'E', '+', '-'

  // what is the requirement for space:
  // leading or trailing

  // what is the requirement for sign:
  // can be the first char, or the first char after E/e
  // +10e2,  10e-5
  // invalid: not first, duplicate before E, duplicate after E

  // the requirement fro dot
  // only before E/e, only once

  // e/E:
  // only one, must have a number before and after it.

  // NUMERIC::= (SPC*)
  //            ['+'|'-']  (NUM*)[DOT(NUM*)]  [(NUM+)('E'|'e')[['+'|'-'](NUM+)]]
  //            (SPC*)

  // 根据代码把有穷自动机画出来。 不然肯定记不住。

}
