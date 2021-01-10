package com.study.practice.class18_enum;

public class Test {

  public static void main(String args[]) {
    RainbowColor[] colors = RainbowColor.values(); // values() 获得列表
    for (RainbowColor c : colors) {
      System.out.println(c);
    }

    RainbowColor color1 = RainbowColor.RED;
    System.out.println(color1.ordinal()); // ordinal()

    RainbowColor color2 = RainbowColor.valueOf("RED"); // valuesOf 大写输入
    System.out.println(color2.ordinal());

    System.out.println(color2 == color1); // 等号比较的是地址。static field所以是同一个。
  }
}
