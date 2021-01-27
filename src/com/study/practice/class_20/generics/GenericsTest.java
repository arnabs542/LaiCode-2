package com.study.practice.class_20.generics;

public class GenericsTest {
  public static <E extends Comparable<E> & Iterable<E>> E myPrint(E element) {
    E element2 = element;
    int test = element2.compareTo(element);
    return element;
  }
}
