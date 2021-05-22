package com.study.algorithms.class23_graph_search_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeighborFinder {
  private Map<String, Integer> wordIndex = new HashMap<>();
  private List<String> wordList;

  public NeighborFinder(List<String> wordList) {
    for (int i = 0; i < wordList.size(); i++) {
      String word = wordList.get(i);
      wordIndex.put(word, i);
    }
    this.wordList = wordList;
  }

  public List<Integer> findNeighbors(int i) {
    List<Integer> neighbors = new ArrayList<>(16);
    String word = wordList.get(i);
    StringBuilder wordModifier = new StringBuilder(word);
    for (int j = 0; j < wordModifier.length(); j++) {
      char orig = word.charAt(j);
      for (char c = 'a'; c <= 'z'; c++) {
        if (c == orig) {
          continue;
        }
        wordModifier.setCharAt(j, c);
        int neighbor = wordIndex.getOrDefault(wordModifier.toString(), -1);
        if (neighbor != -1) {
          neighbors.add(neighbor);
        }
      }
      wordModifier.setCharAt(j, orig);
    }
    return neighbors;
  }
}
