package model;

import java.util.Comparator;

public class GraphNode {
  public GraphNode[] children;
  public int val;
  public String color; // support for color
  public boolean visited; // isword for tries implementation

  public GraphNode(int x) {
    val = x;
  }
}
