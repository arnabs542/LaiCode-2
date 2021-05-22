package com.study.practice.string_and_integer;

public class Main {
  public static void main(String[] args) {
    String str = "   .1";
    int i = ATOI.atoi(str);
    System.out.println(i);

    System.out.println(itoa(-123));

    i = -1000;
    char c = (char) i;
    System.out.println(c);
    long l = (long) (Math.pow(2, 32) - 1000);
    char d = (char) l;
    System.out.println(d);

    System.out.println(toHigher('c'));

    System.out.println(parseHexDigit('E'));
  }

  public static char toHigher(char lower) {
    return (char) (lower - 'a' + 'A');
  }

  public static int parseHexDigit(char c) {
    if (c >= '0' && c <= '9') {
      return c - '0';
    } else if (c >= 'a' && c <= 'f') {
      return 10 + c - 'a';
    } else if (c >= 'A' && c <= 'F') {
      return 10 + c - 'A';
    }
    // corner case: invalid input, return a default number
    return Integer.MAX_VALUE;
  }

  public static int atoi(String str) {
    // Corner cases:
    /*
     * 1. null or empty string
     * 2. leading spaces - ignore space
     * 3. sign, + or -
     * 4. trailing spaces or other characters
     * 5. handle overflow
     * */

    // Corner cases solutions:
    /*
     * 1. null, "" --> 0
     * 2. "    123" --> 123
     * 3.  "+123"-->123,
     *     "-123" --> -123,
     * 4.  "123    "--> 123 后方空格
     *     "123a" --> 123   前后意外字符
     *     "a123" --> 0
     *     "1.6"  --> 1
     *     "+-123" --> 0
     * 5. overflow --> Integer.MAX_VALUE/MIN_VALUE
     * */
    if (str == null || str.length() == 0) {             // corner case 1
      return 0;
    }
    int n = str.length();
    int i = 0;
    while (i < n && str.charAt(i) == ' ') {             // corner case 2
      i++;
    }
    boolean positive = true;
    if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) { // corner case 3
      positive = (str.charAt(i) == '+');
      i++;
    }

    // handle会不会overflow，要用long，不然sum本体也overflow了
    long sum = 0; // corner case 5, overflow. we need a sum, not integer.
    while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') { // corner case 4, "+-12"是进不来while的
      sum = sum * 10 + (str.charAt(i) - '0');
      if (positive && sum > Integer.MAX_VALUE) {  // corner case 5     implicitly type conversion
        return Integer.MAX_VALUE;
      }
      if (!positive && sum > Integer.MAX_VALUE) {  // corner case 5
        return Integer.MIN_VALUE;
      }
      i++;
    }
    sum = positive ? sum : -sum; // corner case 3
    return (int) sum;
  }

  public static String itoa(int i) {
    if (i == 0) {
      return "0";
    }
    boolean isNegative = false;
    if (i < 0) {
      isNegative = true;
      i = -i;
    }
    StringBuilder sb = new StringBuilder();
    while (i != 0) {
      int digit = i % 10; // 1912 % 10 --> 2
      i /= 10; // 1912 / 10 --> 191
      sb.append(digit); // 如果直接填写，那么用'0' + i
    }
    if (isNegative) {
      sb.append("-");
    }
    sb.reverse();
    return sb.toString();
  }
}
