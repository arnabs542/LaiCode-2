package com.study.practice.class07_graph_binary_tree_I;

import java.util.ArrayList;
import java.util.List;

public class KnaryTreeNode {
  int key;
  List<KnaryTreeNode> children;
  KnaryTreeNode parent;
  public KnaryTreeNode(int key) {
    this.key = key;
    this.children = new ArrayList<>();
  }
}
