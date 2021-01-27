package com.study.practice.class_22_concurrency;

import java.util.Arrays;

public class MyHashMapSafe<K, V> {
  // nested class
  public class Entry<K, V> {
    // use separate chain to handle hash collision
    final K key;
    V value;
    Entry<K, V> next;
    public Entry(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  // API: put, get --> helper equalsKey, hash, needRefactor, rehash
  // fields: loadFactor, capacity, size, Entry[]
  private final static float LOAD_FACTOR = 0.75f;
  private final static int INIT_CAPACITY = 16;
  private final float loadFactor;
  private int size;
  private Entry<K, V>[] array;

  public MyHashMapSafe(float loadFactor, int capacity) {
    // sanity check
    if (loadFactor <= 0 || capacity <= 0) {
      throw new IllegalArgumentException("Illegal load factor or capacity");
    }
    this.loadFactor = loadFactor;
    this.size = 0;
    this.array = new Entry[capacity];
  }

  public MyHashMapSafe() {
    this(LOAD_FACTOR, INIT_CAPACITY); // this 调用自己的构造函数
  }

  // small API: size(), isEmpty(), clear()
  public synchronized int size() {
    return array.length;
  }
  public synchronized boolean isEmpty() {
    return array.length == 0;
  }
  public synchronized void clear() {
    Arrays.fill(array, null);
    size = 0;
  }

  // put
  // case 1: update
  // case 2: insert new
  public synchronized V put(K key, V value) {
    int index = getIndex(hash(key));
    Entry<K, V> cur = array[index];
    // case 1: update
    while (cur != null) {
      if (equalsKey(cur.key, key)) { // NPE risk, key may be null
        V prev = cur.value;
        cur.value = value;
        return prev;
      }
      cur = cur.next;
    }
    // case 2: insert new
    Entry<K, V> newHead = new Entry<>(key, value);
    newHead.next = array[index];
    array[index] = newHead;
    // post processing: 检查是否需要rehash
    size++;
    if (needRehashing()) {
      rehashing();
    }
    return null;
  }

  // get
  public synchronized V get(K key) {
    int index = getIndex(hash(key));
    Entry<K, V> cur = array[index];
    while (cur != null) {
      if (equalsKey(cur.key, key)) {
        return cur.value;
      }
      cur = cur.next;
    }
    return null;
  }

  private boolean equalsKey(K k1, K k2) {
    // corner case: key may be null.
//        if (k1 == null && k2 == null) {
//            return true;
//        } else if (k1 == null || k2 == null) {
//            return false;
//        } else if (k1.equals(k2)) {
//            return true;
//        }
//        return false;
    return (k1 == k2) || k1.equals(k2);
  }

  private void rehashing() {
    Entry<K, V>[] oldArray = array;
    array = new Entry[array.length * 2];

    for (Entry<K, V> cur : oldArray) {
      while (cur != null) {
        int index = getIndex(hash(cur.key));
        Entry<K, V> next = cur.next;
        cur.next = array[index];
        array[index] = cur;
        cur = next;
      }
    }
  }

  private boolean needRehashing() {
    if (size / array.length >= loadFactor) {
      return true;
    }
    return false;
  }

  private int hash(K key) {
    if (key == null) {
      return 0;
    }
    return key.hashCode(); // 必须实现实现hashCode和equals才能放进来
  }

  private int getIndex(int hash) {
    return hash & (array.length - 1); // 解决溢出和取模一并搞定
  }

  // advanced API: remove, containsKey, containsValue
  public synchronized V remove(K key) {
    int index = getIndex(hash(key));
    // 操作链表，从链表中删除：prev.next = cur.next 就可以把cur卸下来
    Entry<K, V> cur = array[index];
    Entry<K, V> prev = null;
    while (cur != null) {
      if (equalsKey(cur.key, key)) {
        // case 1: 第一个
        if (prev == null) {
          array[index] = cur.next;
          size--;
          return cur.value;
        } else {
          // case 2: 在中间或者末尾
          prev.next = cur.next;
          size--;
          return cur.value;
        }
      }
      prev = cur;
      cur = cur.next;
    }
    return null;
  }
}
