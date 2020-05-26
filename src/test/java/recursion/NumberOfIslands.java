package recursion;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
 * may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

  static int[] dx = new int[] {-1, 1, 0, 0};
  static int[] dy = new int[] {0, 0, -1, 1}; // posible moves

  // using recursion, dfs
  public void connect(char[][] grid, int x, int y) {
    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') return;
    grid[x][y] = '0';
    for (int d = 0; d < 4; d++) connect(grid, x + dx[d], y + dy[d]);
  }

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          connect(grid, i, j);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(
        new NumberOfIslands()
            .numIslands(
                new char[][] {
                  {'1', '1', '1', '1', '0'},
                  {'1', '1', '0', '1', '0'},
                  {'1', '1', '0', '0', '0'},
                  {'0', '0', '0', '0', '0'},
                }));

    //0101
    //0011
    //0101

    //0111
    //0001
    //0101

    //0110
    //0001
    //1010
  }
}
