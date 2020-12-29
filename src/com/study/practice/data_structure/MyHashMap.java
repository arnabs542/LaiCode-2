package com.study.practice.data_structure;

import java.util.Objects;

public class MyHashMap { // 先不写generics
    // key - String
    // value - Integer

    // API:
    //  get - input <key, value>
    //        output null or previous value if key existed
    //  set - input key
    //        output value or null if key not exist

    // Constructor - default or custom? field?
    //  field: capacity, load factor, size, array(bucket)
    //  因为capacity、load factor可以让用户传，也可以不传用默认，所以设计两个constructor
    //  注意：size 指元素个数

    // Entry - stands for key-value pair
    // storing key and value and next; - separate chaining


    // 1. Entry nested class
    public static class Entry {
        final String key;
        Integer value;
        Entry next;

        public Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f; // 加f才代表是float，不然是double然后报错
    // 4 fields
    private final int initCapacity;
    private final float loadFactor;
    private int size;
    private Entry[] array;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR); // call另一个constructor。
    }

    public MyHashMap(int initCapacity, float loadFactor) {
        if (initCapacity <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("Illegal capacity or load factor.");
        }
        this.initCapacity = initCapacity;           // capacity
        this.loadFactor = loadFactor;     // load factor
        this.size = 0;                      // current elements
        this.array = new Entry[initCapacity];    // buckets
    }

    // API - 1
    // get - input key, output null or value
    //     |- hash(key) --> get index
    //     |- equalsKey(key1, key2)
    // 注意1：hashCode可能是overflow，求index要留意，而且abs可能还是overflow：Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE
    // 注意2：key可能是null，equals和hash都要当心


    public Integer get(String key) {
//        int index = key.hashCode() % capacity; // 出错，key可能是null
        int index = hash(key);
        Entry head = array[index];
        while (head != null) {
//            if (head.key.equals(key)) { // 出错，key可能是null
//                return head.value;
//            }
            // 要考虑 1.两个都是null相等，2.一个是null跳过 3，都不是null调用equals
            if (equalsKey(head.key, key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    private boolean equalsKey(String k1, String k2) {
        // corner case: key may be null.
//        if (k1 == null && k2 == null) {
//            return true;
//        } else if (k1 == null || k2 == null) {
//            return false;
//        } else if (k1.equals(k2)) {
//            return true;
//        }
//        return false;
        // short way:
        return Objects.equals(k1, k2); // i.e. (k1 == k2) || (k1 != null && k1.equals(k2))
    }

    private int hash(String key) {
        // get index
        // 1. corner case: key may be null
        if (key == null) {
            return 0;
        }
        // 2. return index, notice: hashCode may be negative
        // 最高位是0，与一下
        return key.hashCode() & 0x7FFFFFFF % array.length;
    }


    // API - 2
    // put - input key,value, output null or previous value
    //     |- needRefactor()
    //     |- rehash()
    // 注意：rehash的prepend，考虑separate chaining

    public Integer put(String key, Integer value) {
        int index = hash(key);
        Entry head = array[index];
        Entry cur = head;
        // step1: iterate through, if exists
        while (cur != null) {
            if (equalsKey(cur.key, key)) {
                Integer res = cur.value;
                cur.value = value;
                return res;
            }
            cur = cur.next;
        }
        // step2: if not exists, add new one, and check load factor
        Entry newEntry = new Entry(key, value);
        newEntry.next = head;
        array[index] = newEntry; // 接在头部
        size++;
        if (needRefactor()) {
            rehash();
        }

        return null;
    }

    private boolean needRefactor() {
        float ratio = (float)size / array.length;
        return ratio >= loadFactor;
    }

    private void rehash() {
        Entry[] oldArray = array;
        array = new Entry[array.length * 2];

        for (Entry cur : oldArray) {
            while (cur != null) {
                Entry next = cur.next;
                int index = hash(cur.key);
                // prepend into new
                cur.next = array[index]; // concat
                array[index] = cur; // prepend
                cur = next;
            }
        }
    }
}
