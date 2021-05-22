package com.study.algorithms.class23_graph_search_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tracer2 {
  public Tracer2(List<String> words) {
    this.words = words;
    preds = new ArrayList<>(words.size());
    for (int i = 0; i < words.size(); i++) {
      preds.add(new ArrayList<>(16));
    }
  }

  public void addPredecessor(int x, int y) {
    preds.get(y).add(x);
  }

  public List<List<String>> findLadders(int beginIndex, int y) {
    List<List<String>> ladders = new ArrayList<>();
    List<String> trace = new ArrayList<>();
    trace.add(words.get(y));
    findLaddersHelper(beginIndex, y, trace, ladders);
    return ladders;
  }

  private void findLaddersHelper(int beginIndex, int y, List<String> trace,
                                 List<List<String>> ladders) {
    if (beginIndex == y) {
      List<String> ladder = new ArrayList<>(trace);
      Collections.reverse(ladder);
      ladders.add(ladder);
      return;
    }
    for (int x : preds.get(y)) {
      trace.add(words.get(x));
      findLaddersHelper(beginIndex, x, trace, ladders);
      trace.remove(trace.size() - 1);
    }
  }

  private List<String> words;
  private List<List<Integer>> preds;
}
