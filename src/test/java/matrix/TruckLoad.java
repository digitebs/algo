package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
  count adjacent values

  similar to number of island
 */
public class TruckLoad {

  int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

  void dfs(List<List<Integer>> grid, int i, int j) {
    int rows = grid.size();
    int columns = grid.get(0).size();
    if (grid.get(i).get(j) == 0) return;

    grid.get(i).set(j, 0);
    for (int k = 0; k < 4; k++) { // neighbors or child nodes
      int a = i + dx[k];
      int b = j + dy[k];
      if (a >= 0 && b >= 0 && a < rows && b < columns) {
        dfs(grid, a, b);
      }
    }
  }

  int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {

    // WRITE YOUR CODE HERE
    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < column; j++) {
        if (grid.get(i).get(j) == 1) {
          count++;
          dfs(grid, i, j);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    TruckLoad tl = new TruckLoad();
    List<List<Integer>> grid = new ArrayList<>();
    List<Integer> a = Arrays.asList(1, 1, 0, 0);
    List<Integer> b = Arrays.asList(0, 0, 1, 0);
    List<Integer> c = Arrays.asList(0, 0, 0, 0);
    List<Integer> d = Arrays.asList(1, 0, 1, 1);
    List<Integer> f = Arrays.asList(1, 1, 1, 1);
    grid.add(a);
    grid.add(b);
    grid.add(c);
    grid.add(d);
    grid.add(f);
    int r = tl.numberAmazonTreasureTrucks(5, 4, grid);
    System.out.println(r);
  }
}
