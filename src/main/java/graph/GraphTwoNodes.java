package graph;

public class GraphTwoNodes {

  /** using dfs with adjacency matrix */
  static int[][] matrix =
      new int[][] {
        {0, 1, 0, 0},
        {1, 0, 1, 0},
        {0, 1, 0, 1},
        {0, 0, 1, 0}
      };

  static int[] visited = new int[matrix.length]; // everything 0 means not yet visited

  // where b is the target
  static boolean route(int a, int k) {
    // if the node is is itself return true;
    visited[a] = 1;
    if (a == k) return true;
    for (int i = 0; i < matrix[a].length; i++) {
      if (matrix[a][i] == 1 && visited[i] == 0) return route(i, k);
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(route(0, 3)); // check if theres aroute to 0 and 2
  }
}
