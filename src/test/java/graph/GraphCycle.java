package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphCycle {
  // thsi is how you reperes
  static LinkedList<Integer> adj[];

  static boolean hasCycle(int a, boolean visited[], int parent) {
    visited[a] = true;
    // System.out.println(a);
    List<Integer> child = adj[a];
    for (Integer c : child) {
      if (!visited[c]) {
        if (hasCycle(c, visited, a)) return true;
      } else if (c != parent) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int n = 5;
    adj = new LinkedList[n];
    adj[0] = new LinkedList<>(Arrays.asList(1, 2));
    adj[1] = new LinkedList<>(Arrays.asList(0, 2, 3));
    adj[2] = new LinkedList<>(Arrays.asList(0, 1));
    adj[3] = new LinkedList<>(Arrays.asList(4));
    adj[4] = new LinkedList<>(Arrays.asList(3));

    System.out.println(hasCycle(3, new boolean[n], -1)); //
  }
}
