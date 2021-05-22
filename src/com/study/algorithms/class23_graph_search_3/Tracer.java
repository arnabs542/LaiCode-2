package com.study.algorithms.class23_graph_search_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tracer {
  public Tracer(List<String> words) {
    this.words = words;

    pred = new int[words.size()];
    Arrays.fill(pred, -1);
  }

  // Called when we generate y from x.
  public void addPredecessor(int x, int y) {
    pred[y] = x;
  }

  public List<String> findLadder(int y) {
    List<String> ladder = new ArrayList<>();
    while (y != -1) {
      ladder.add(words.get(y));
      y = pred[y];
    }
    Collections.reverse(ladder);
    return ladder;
  }

  private List<String> words;
  private int[] pred;
}
