package array;

/*
At the end, the "skyline" when viewed from all four directions of the grid, i.e. top,
 bottom, left, and right, must be the same as the skyline of the original grid.

 // contour

 */
public class MaxSkyline {
  // skyline of building view from side and top
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    // scan from top to bottom
    int n = grid.length;
    int[] vArr = new int[n];
    int[] hArr = new int[n];
    /** find the max first ok??? */
    for (int i = 0; i < grid.length; i++) {
      int v = 0, h = 0;
      for (int j = 0; j < grid.length; j++) {
        v = Math.max(grid[j][i], v);
        h = Math.max(grid[i][j], h);
      }
      vArr[i] = v;
      hArr[i] = h;
    }

    int sum = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        sum += Math.min(hArr[i], vArr[j]) - grid[i][j];
      }
    }
    return sum;
  }
}
