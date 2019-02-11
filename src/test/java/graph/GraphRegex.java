package graph;

import java.util.ArrayList;

public class GraphRegex {

    // implemented using adjacency matrix. nfa. non deterministic finite automata
    ArrayList<Integer>[] bag;     //adjacency list;
    boolean visited[];

    public void dfs(ArrayList<Integer>[] bag, int i) {
        visited[i] = true;
        for (Integer b : bag[i]) {
            if (!visited[b]) dfs(bag, b);
        }
    }
    public boolean isMatch(String s, String p) {
        int M = p.length();
        bag = new ArrayList[M + 1];
        visited = new boolean[M + 1];

        char[] re = p.toCharArray();
        for (int i = 0; i <= M; i++) {
            bag[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            if (i < M - 1 && p.charAt(i + 1) == '*') {// create an edge from previos;
                bag[i].add(i + 1);
                bag[i + 1].add(i);
            }
            if(p.charAt(i) =='*')
                bag[i].add(i+1);
        }
        dfs(bag, 0);
        ArrayList<Integer> pc = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            if (visited[i]) pc.add(i);
        }
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            ArrayList<Integer> match = new ArrayList<>();
            for (int v : pc) {
                if(v == M) continue;
                if (c1 == re[v] || re[v] == '.') match.add(v + 1);
            }
            visited = new boolean[M+1]; // clear it all
            for (Integer m : match) dfs(bag, m);
            pc = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if (visited[j]) pc.add(j);
            }
        }

        for (int v : pc) {
            if (v == M) return true;
        }
        return false;
    }

}
