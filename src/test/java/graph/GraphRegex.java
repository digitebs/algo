package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphRegex {
  // implemented using adjacency matrix. nfa. non deterministic finite automata
  // ArrayList<Integer>[] bag; // adjacency list;
  // boolean visited[];

  static ArrayList<Integer>[] bag; // adjacency list;
  static boolean visited[];

  static void dfs(int i) {
    visited[i] = true;
    for (Integer b : bag[i]) {
      if (!visited[b]) dfs(b);
    }
  }

  static boolean isMatch(String s, String p) {
    int M = p.length();
    bag = new ArrayList[M + 1];
    visited = new boolean[M + 1];
    char[] re = p.toCharArray();
    for (int i = 0; i <= M; i++) {
      bag[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      if (i < M - 1 && re[i + 1] == '*') { // create an edge from previos;
        bag[i].add(i + 1);
        bag[i + 1].add(i);
      }
      if (re[i] == '*') bag[i].add(i + 1);
    }
    //    System.out.println(Arrays.deepToString(bag));
    dfs(0);
    Queue<Integer> match = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      for (int j = 0; j < M; j++) {
        if (!visited[j]) continue;
        if (c == re[j] || re[j] == '.') match.offer(j + 1);
      }

      visited = new boolean[M + 1]; // clear it all
      while (!match.isEmpty()) dfs(match.poll());
      // System.out.println(Arrays.toString(visited));
    }

    return visited[M];
  }

  public static void main(String[] args) {
    //  System.out.println(isMatch("acd", "ab*c."));
    GraphRegex gr = new GraphRegex();
    System.out.println(gr.isMatch("ab", ".*c"));
    //     System.out.println(gr.isMatch("aa", "a*"));
    //    System.out.println(gr.isMatch("aab","c*a*b"));
    //    System.out.println(gr.isMatch("mississippi", "mis*is*p*."));
    //    System.out.println(gr.isMatch("mississippi", "mis*is*ip*."));
    System.out.println(isMatch("abbbbaz", "a.*a*"));
    System.out.println(isMatch("abbbbaz", "ab*a*"));
  }
}
