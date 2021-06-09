package com.study.algorithms.class10_recursion_2.重听;

public class AbbMatch {
    // Abbreviation Matching，检查输入的pattern是不是输入的string的abbrev
    // https://docs.google.com/document/d/1VT9I1JbRP4_TkQJnxJrLXFhgqRrZZoPbShgYK5N0bME/edit

    // 可以用iterative写，特别简单（两个while循环套一起）
    // 这里为了锻炼recursion，就用recursion

    //  student
    //       |
    //  s2d2t
    //     |
    // 遇到数字就往后跳n次
    // 每次pattern先走，然后看如果是letter，就走1个input，并检查是否相同
    // 如果是num，就记录完这个num，停在num后方的letter。input走num个位置，走到letter上检查是否相等。
    public boolean match(String input, String pattern) {

    }
}
