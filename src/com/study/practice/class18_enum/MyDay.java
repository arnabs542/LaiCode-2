package com.study.practice.class18_enum;


final class MyDay extends Enum {

  public static MyDay[] values() {
    return (MyDay[]) $VALUES.clone();
  }

  public static MyDay valueOf(String s) {
    return (MyDay) Enum.valueOf(MyDay, s);
  }

  private MyDay(String s, int i) {
    super(s, i);
  }

  public static final MyDay MONDAY;
  public static final MyDay TUESDAY;
  public static final MyDay WEDNESDAY;
  public static final MyDay THURSDAY;
  public static final MyDay FRIDAY;
  public static final MyDay $VALUES[];

  static {
    MONDAY = new MyDay("MONDAY", 1);
    TUESDAY = new MyDay("TUESDAY", 2);
    WEDNESDAY = new MyDay("WEDNESDAY", 3);
    THURSDAY = new MyDay("THURSDAY", 4);
    FRIDAY = new MyDay("FRIDAY", 5);

    $VALUES = (new MyDay[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY});
  }
}


