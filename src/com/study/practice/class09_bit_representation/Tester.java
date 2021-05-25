package com.study.practice.class09_bit_representation;

public class Tester {

  public static void main(String[] args) {
    // what happens when you convert between two integer types:

    // case1: same length
    // Principle 1: the binary representation doesn’t change
    short a = -1; 		// 0xFFFF	  = -1
    char b = (char)a; // 0xFFFF 	= 65535

    // case2: small -> large
    // Principle 2: source is signed, prepend the sign bit. otherwise prepend 0
    int c = a;    // 0xFFFFFFFF   = -1
    int d = b;    // 0x0000FFFF   = 65535

    // case3: large -> small
    // Principle 3: 简单截断，无论有无signed
    short e = (short) c;  // 0xFFFF = -1
    char f = (char) c;    // 0xFFFF = 65535

    ReverseBits rb = new ReverseBits();
    int n = 1;
    int m = rb.reverseBits(n);
    System.out.println(m);

    long nn = 1;
    long mm = rb.reverseBits(nn);
    System.out.println(mm);

    System.out.println(rb.reverseII(0x10101010));

    HexRepresentation hr = new HexRepresentation();
    System.out.println(hr.hex1(48));
    System.out.println(hr.hex2(48));
  }
}
