package graph;

import java.util.Arrays;

/*
Input: (adjacency matrix)
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
The 2nd student himself is in a friend circle. So return 2.
 */
public class FindCircles {
  /*
     use dfs and mark them as visited means its all connected
  */
  public int dfs(int[][] M, int node) {
    int count = 0;
    for (int i = 0; i < M[node].length; i++) {
      if (M[node][i] != 0) {
        M[node][i] = 0;
        count += dfs(M, i);
        count++;
      }
    }
    return count;
  }

  public int findCircleNum(int[][] M) {
    int count = 0;
    for (int i = 0; i < M.length; i++) {
      // travrese to all vertex and dfs it
      if (dfs(M, i) > 0) count++;
    }
    System.out.println(Arrays.deepToString(M));
    return count;
  }
}
