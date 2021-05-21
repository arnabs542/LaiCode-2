package com.study.practice.class05_arraylist;


import java.util.ArrayList;
import java.util.LinkedList;

// 下面的E，实际上要替换成一个具体的东西的。
abstract class MyArrayList<E> { // E可以放一个Interface，传入具体实现
    private E[] array; // the maintained array, the current maximum capacity is array.length
    private int size; // size如果把array装满了，那么需要新开一个array，然后copy elements

    // APIs
    abstract E get(int index); // O(1)
    abstract boolean set(int index, E e); // O(1)
    // set要替换，所以index范围是[0,size)
    abstract boolean add(E e); // Amortized Time Complexity O(1)        since: (O(n) + n*O(1)) / n = O(2) => O(1)
    // avg Time 和 amortized Time 的区别。前者是放不同input，然后求期望；后者input是有内在关联的，一个O(n)的必然引起一组O(1) 那么就考虑这一组的平均值。
    abstract boolean add(int index, E e); // O(n) // 1. expand if necessary 2. right move all elements after index by 1  3. set the elements at index
    // add要插入，所以index范围是[0,size]
    abstract E remove(int index); // O(n)
    // Java设计它不会shrink。 曾经装到过这些元素，我就认为你可能还会要这么大。
    abstract void trimToSize();
    // 可以用trimToSize手动shrink cap到size
}