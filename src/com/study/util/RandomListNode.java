package com.study.util;

import java.util.Objects;

public class RandomListNode {
    public int key;
    public RandomListNode next;
    public RandomListNode other;

    public RandomListNode(int key, RandomListNode next, RandomListNode other) {
        this.key = key;
        this.next = next;
        this.other = other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomListNode that = (RandomListNode) o;
        return key == that.key && Objects.equals(next, that.next) && Objects.equals(other, that.other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, next, other);
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "key=" + key +
                ", next=" + next +
                ", other=" + other +
                '}';
    }
}
