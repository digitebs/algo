package graph;

import java.util.Arrays;

/*
medium*

 There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take
 course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to
 finish all courses?

 Input: numCourses = 2, prerequisites = [[1,0]]

 Output: true
 Explanation: There are a total of
 2 courses to take. To take course 1 you should have finished course 0. So it is possible. Example
 2:

 Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 Output: false
 Explanation: There are a
 total of 2 courses to take. To take course 1 you should have finished course 0, and to take
 course 0 you should also have finished course 1. So it is impossible.
*/
public class CourseSchedule {

  public boolean dfs(int[][] edges, int v, boolean visited[]) {
    if (visited[v]) return true; // cycle
    visited[v] = true;

    int i = Arrays.binarySearch(edges, new int[] {v}, (a, b) -> a[0] - b[0]);
    for (int s = i - 1; s >= 0 && edges[i][0] == edges[s][0]; s--)
      if (dfs(edges, edges[s][1], visited)) return true; // owaky
    for (int e = i; e >= 0 && e < edges.length && edges[i][0] == edges[e][0]; e++)
      if (dfs(edges, edges[e][1], visited)) return true; // owakay

    visited[v] = false; // back track
    return false;
  }

  /* Edges is represented as edge list, need extra sorting */
  public boolean canFinish(int n, int[][] edges) {
    Arrays.sort(edges, (a, b) -> a[0] - b[0]);
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (dfs(edges, i, visited)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    CourseSchedule cs = new CourseSchedule();
    System.out.println(cs.canFinish(4,new int[][]{{0,1},{2,3}}));
    System.out.println(cs.canFinish(5,new int[][]{{0,1}, {1,2}, {2,3}, {3,1}}));
    System.out.println(cs.canFinish(5,new int[][]{{0,1} ,{1,2} ,{2,3}, {2,4} ,{4,1}}));
    System.out.println(cs.canFinish(2,new int[][]{{1,0}}));
  }
}
