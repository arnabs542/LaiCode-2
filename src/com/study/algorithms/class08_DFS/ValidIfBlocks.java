package com.study.algorithms.class08_DFS;

import java.util.ArrayList;
import java.util.List;
public class ValidIfBlocks {
  // Similar to all valid parentheses
  // Assumption:
  // 1. input n
  // 2. output List of String, each String is a result
  // 3. n <= 0 return empty list
  public List<String> printIfPairs(int n) {
    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();
    DFS(n, 0, 0, sb, result); // containing post-processing
    return result;
  }

  private void DFS(int n, int left, int right, StringBuilder sb, List<String> result) {
    // base case
    if (sb.length() == 2 * n) {
      // post-processing
      result.add(format(sb));
      return;
    }
    // case 1: add {
    if (left < n) {
      sb.append("{");
      DFS(n, left + 1, right, sb, result);
      sb.deleteCharAt(sb.length() - 1); // 吃了吐
    }
    // case 2: add }
    if (right < left) {
      sb.append("}");
      DFS(n, left, right + 1, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  private String format(StringBuilder sb) {
    int indent = 0;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '{') {
        addIndent(result, indent);
        result.append("if {\n");
        indent++;
      } else {
        indent--;
        addIndent(result, indent);
        result.append("}\n");
      }
    }
    return result.toString();
  }

  private void addIndent(StringBuilder result, int indent) {
    for (int i = 0; i < indent; i++) {
      result.append("  "); // two spaces
    }
  }
}
