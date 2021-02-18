package com.study.practice.class_23_concurrency;

import java.util.Arrays;

public class HashMapWrong<K, V> {
  static class Node<K, V> {
    final K key;
    V value;
    Node<K, V> next;
    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() {
      return key;
    }

    public synchronized V getValue() {
      return value;
    }

    public synchronized void setValue(V value) {
      this.value = value;
    } // 1. Do you need this? NO
  }

  public static final int DEFAULT_CAPACITY = 16;
  public static final float DEFAULT_LOAD_FACTOR = 0.75f;

  private Node<K, V>[] array;
  private int size;
  private float loadFactor;

  public  HashMapWrong(int cap, float loadFactor) {
    if (cap <= 0) {
      throw new IllegalArgumentException("cap can not be <= 0.");
    }
    array = (Node<K, V>[]) (new Node[cap]);
    this.loadFactor = loadFactor;
    size = 0;
  }

  public HashMapWrong() {
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  } // 2. Need to synchronize? YES

  public synchronized void clear() {
    Arrays.fill(array, null);
    size = 0;
  }

  private int hash(K key) { // 3. Synchronize on private methods? NO
    if (key == null) {
      return 0;
    }
    int code = key.hashCode();
    return code & 0x7FFFFFFF;
  }

  private int getIndex(int hash) {
    return hash % array.length;
  }

  private boolean equalsKey(K k1, K k2) {
    return k1 == k2 || k1 != null && k1.equals(k2);
  }

  public synchronized V put(K key, V value) {
    int index = getIndex(hash(key));
    Node<K, V> cur = array[index];
    while (cur != null) {
      if (equalsKey(cur.key, key)) {
        V result = cur.value;
        cur.value = value;
        return result;
      }
      cur = cur.next;
    }
    Node<K, V> newHead = new Node<>(key, value);
    newHead.next = array[index];
    array[index] = newHead;
    size++;
    if (needRehashing()) {
      rehashing();
    }
    return null;
  }

  private boolean needRehashing() {
    float ratio = (size + 0.0f) / array.length;
    return ratio >= loadFactor;
  }

  private boolean rehashing() {
// new double size array.
// for each node in the old array
// do the put() operation to the new larger array
    return true;
  }

  public synchronized V get(K key) { // 4. Synchronize for public and/or
    // read-only methods? YES
    int index = getIndex(hash(key));
    Node<K, V> cur = array[index];
    while (cur != null) {
      if (equalsKey(cur.key, key)) {
        return cur.value;
      }
      cur = cur.next;
    }
    return null;
  }

  public synchronized boolean containsKey(K key) {
    int index = getIndex(hash(key));
    for (Node<K, V> node = array[index]; node != null; node = node.next)
    {
      if (equalsKey(node.key, key)) {
        return true;
      }
    }
    return false;
  }

  private boolean equalsValue(V v1, V v2) {
    return v1 == v2 || v1 != null && v1.equals(v2);
  }

  public synchronized boolean containsValue(V value) {
    if (isEmpty()) {
      return false;
    }
    for (Node<K, V> node : array) {
      while (node != null) {
        if (equalsValue(node.value, value)) {
          return true;
        }
        node = node.next;
      }
    }
    return false;
  } // 当前thread instance vs. this

  public synchronized V remove(K key) {
    int index = getIndex(hash(key));
    Node<K, V> prev = null;
    Node<K, V> cur = array[index];
    while (cur != null) {
      if (equalsKey(cur.key, key)) {
        if (prev == null) {
          array[index] = cur.next;
          size--;
          return cur.value;
        } else {
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
