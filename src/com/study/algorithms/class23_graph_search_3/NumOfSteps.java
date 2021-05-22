package com.study.algorithms.class23_graph_search_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class State {
  public State(int[] values) {
    values_ = values;
    h_ = 0;
    for (int t = 0; t < 8; ++t) {
      h_ = 10 * h_ + values[t]; // The hash code of this 1D array that contains 8 integers is that I treat it as a 8-digits decimal.
      if (values[t] == 0) {
        zero_p_ = t;
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof State)) {
      return false;
    }
    State s = (State)o;
    return this.h_ == s.h_;
  }

  @Override
  public int hashCode() {
    return h_;
  }

  public static List<State> generateNewStates(State s) {
    // These two combines together describes the following 4 directions in order:
    // Up, Right, Down, Left(assuming y axis is going from left to right and x axis is going from top
    // to bottom)
    int[] DX = {-1, 0, 1, 0};
    int[] DY = {0, 1, 0, -1};
    int x = s.zero_p_ / 4;
    int y = s.zero_p_ % 4;
    ArrayList<State> new_states = new ArrayList<>();
    for (int d = 0; d < 4; ++d) {
      int nx = x + DX[d]; // The new x coordinate equals to the old one + x-axis increment of the specified direction
      int ny = y + DY[d];
      if (0 <= nx && nx < 2 && 0 <= ny && ny < 4) {
        int[] new_values = s.values_.clone();
        swap(new_values, s.zero_p_, nx * 4 + ny);
        new_states.add(new State(new_values));
      }
    }
    return new_states;
  }

  private static void swap(int[] arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }

  private int[] values_; // Flatten the 2*4 matrix into a 8 elements 1D array.
  private int h_;
  private int zero_p_ = 0;
}

public class NumOfSteps {
  public int numOfSteps(int[] values) {
    // Write your solution here
    State init = new State(values);
    HashSet<State> visited = new HashSet<>();
    visited.add(init);
    ArrayList<State> frontier = new ArrayList<>();
    frontier.add(init);
    int level = 0;
    State target = new State(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
    while (!frontier.isEmpty()) {
      ArrayList<State> next = new ArrayList<>();
      for (State s : frontier) {
        if (s.equals(target)) {
          return level;
        }
        for (State new_state : State.generateNewStates(s)) {
          if (!visited.contains(new_state)) {
            visited.add(new_state);
            next.add(new_state);
          }
        }
      }
      frontier = next;
      level += 1;
    }
    return -1;
  }
}

