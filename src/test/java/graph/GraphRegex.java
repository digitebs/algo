package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphRegex {
  // implemented using adjacency matrix. nfa. non deterministic finite automata
  // ArrayList<Integer>[] bag; // adjacency list;
  // boolean visited[];

  static ArrayList<Integer>[] bag; // adjacency list;
  static boolean visited[];

  static void dfs(ArrayList<Integer>[] adj, int i) {
    visited[i] = true;
    for (Integer b : adj[i]) {
      if (!visited[b]) dfs(adj, b);
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
      if (i < M - 1 && p.charAt(i + 1) == '*') { // create an edge from previos;
        bag[i].add(i + 1);
        bag[i + 1].add(i);
      }
      if (p.charAt(i) == '*') bag[i].add(i + 1);
    }
    dfs(bag, 0);
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      ArrayList<Integer> match = new ArrayList<>();
      for (int j = 0; j < M; j++) {
        if ( !visited[j]) continue;
        if (c1 == re[j] || re[j] == '.') match.add(j + 1);
      }

      // System.out.println(match+" "+re[match.get(0)]);
      visited = new boolean[M + 1]; // clear it all
      match.forEach(m -> dfs(bag, m));
    }

    return visited[M];
  }

  public static void main(String[] args) {
    //  System.out.println(isMatch("acd", "ab*c."));
    GraphRegex gr = new GraphRegex();
   // System.out.println(gr.isMatch("ab", ".*c"));
   //  System.out.println(gr.isMatch("aa", "a*"));
   // System.out.println(gr.isMatch("aab","c*a*b"));
   // System.out.println(gr.isMatch("mississippi", "mis*is*p*."));
    System.out.println(gr.isMatch("mississippi", "mis*is*ip*."));
    //  System.out.println(isMatch("abbbbaz", "a.*a*"));
    // System.out.println(isMatch("abbbbaz", "ab*a*"));
  }
}
