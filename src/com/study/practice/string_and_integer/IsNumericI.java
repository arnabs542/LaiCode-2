package com.study.practice.string_and_integer;

public class IsNumericI {
  // 本体不考虑sign
  // "0"          --> true
  // "   0.1"     --> true    space can only be leading or trailing
  // ".1"         --> true    dot can only appear once
  // "1."         --> true
  // "."          --> true
  // ""           --> true

  // "0.1."       --> false  corner case 1
  // "0 1"        --> false  corner case 2
  // "1.0a"         --> false
  // "1   0"         --> false

  // Backus–Naur form
  // SPC::=' '
  // NUM::='0'|'1'| ... |'9'
  // DOT::='.'
  // NUMERIC::= (SPEC*)(NUM*)[DOT(NUM*)](SPC*)
  // []  代表optional， 类似regexp的? (0,1) -- 区别regexp的[],那个指的是exactly once。而且后面可以跟+或者*
  // (*) Items existing 0 or more times
  // (+) Items existing 1 or more times

  public static boolean isNumber(String s) {
    String str = s.trim();
    boolean seenPoint = false;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '.') {
        if (seenPoint) {
          return false;  // corner case 1
        }
        seenPoint = true;
      } else if (c < '0' || c > '9') {
        return false; // corner case 2
      }
    }
    return true;
  }
}
