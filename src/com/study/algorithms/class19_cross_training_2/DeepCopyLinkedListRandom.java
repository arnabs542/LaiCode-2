package com.study.algorithms.class19_cross_training_2;

import java.util.HashMap;
import java.util.Map;

//  Deep Copy Linked List With Random Pointer
//  Each of the nodes in the linked list has another pointer pointing to a random node in the list or null.
//  Make a deep copy of the original list.
//  https://app.laicode.io/app/problem/131
  public class DeepCopyLinkedListRandom {
    private static class Node {
      int value;
      Node next;
      Node random;

      public Node(int value) {
        this.value = value;
      }
    }

    // Method 1: using HashMap to avoid copy multiple times for the same node.
    public Node copy(Node head) {
      if (head == null) {
        return null;
      }
      // Sentinel node to help construct the deep copy.
      Node dummy = new Node(0);
      Node cur = dummy;
      // Maintains the mapping between the node in the original list and
      // the corresponding node in the new list.
      Map<Node, Node> map = new HashMap<>();
      while (head != null) {
        // Copy the current node if necessary.
        if (!map.containsKey(head)) {
          map.put(head, new Node(head.value));
        }
        // Connect the copied node to the deep copy list.
        cur.next = map.get(head);
        // Copy the random node if necessary.
        if (head.random != null) {
          if (!map.containsKey(head.random)) {
            map.put(head.random, new Node(head.random.value));
          }
          // Connect the copied node to the random pointer.
          cur.next.random = map.get(head.random);
        }
        head = head.next;
        cur = cur.next;
      }
      return dummy.next;
    }

    // Method 2: Another three pass solution, not using HashMap,
    // but changing the original list structure during the copy
    // (it will be changed back at the end).
    public Node copyII(Node head) {
      if (head == null) {
        return null;
      }
      // First pass, for each node in the original list, insert a
      // copied node between the node and node.next.
      Node cur = head;
      while (cur != null) {
        // Make a copy of cur node, insert it to the middle of cur and cur.next.
        Node copy = new Node(cur.value);
        copy.next = cur.next;
        cur.next = copy;
        cur = cur.next.next;
      }
      // Second pass, link the random pointer for the copied node.
      cur = head;
      while (cur != null) {
        if (cur.random != null) {
          cur.next.random = cur.random.next;
        }
        cur = cur.next.next;
      }
      // Third pass, extract the copied node.
      cur = head;
      Node dummy = new Node(0);
      Node copyPrev = dummy;
      while (cur != null) {
        copyPrev.next = cur.next;
        cur.next = cur.next.next;
        copyPrev = copyPrev.next;
        cur = cur.next;
      }
      return dummy.next;
    }
  }
