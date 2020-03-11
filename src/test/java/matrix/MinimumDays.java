package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
    given a power grid of 2d matrix, determine how long it will take to turn all the power on. 1 is active 0 inactive.

    an active cell can power its adjacent neighbor(up, down, left,right).
 */
public class MinimumDays {
  int minimumDays(int rows, int columns, List<List<Integer>> grid) {
    int zeroCount,days=-1;
    final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    do {
      zeroCount = 0;
      days++;
      List<List<Integer>> temp = new ArrayList<>();
      IntStream.range(0, rows)
          .forEach(
              x -> {
                temp.add(new ArrayList<>(Collections.nCopies(columns, 0)));
              });

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          if (grid.get(i).get(j) == 1) {
            temp.get(i).set(j, 1);
            for (int k = 0; k < 4; k++) { // neighbors or child nodes
              int a = i + dx[k];
              int b = j + dy[k];
              if (a >= 0 && b >= 0 && a < rows && b < columns) temp.get(a).set(b, 1);
            }
          } else if (++zeroCount == rows * columns) return -1;
        }
      }
      grid = temp; // copies
    } while (zeroCount > 0);
    return days;
  }

  public static void main(String[] args) {
    //

    MinimumDays md = new MinimumDays();
    List<List<Integer>> arr = new ArrayList<>();
    arr.add(Arrays.asList(1, 0, 0, 0, 0));
    arr.add(Arrays.asList(0, 1, 0, 0, 0));
    arr.add(Arrays.asList(0, 0, 1, 0, 0));
    arr.add(Arrays.asList(0, 0, 0, 1, 0));
    arr.add(Arrays.asList(0, 0, 0, 0, 1));
    System.out.println(md.minimumDays(5, 5, arr));

    List<List<Integer>> arr1 = new ArrayList<>();
    arr1.add(Arrays.asList(1, 1, 1));
    arr1.add(Arrays.asList(1, 1, 1));
    arr1.add(Arrays.asList(1, 1, 1));
    System.out.println(md.minimumDays(3, 3, arr1));

    List<List<Integer>> arr2 = new ArrayList<>();
    arr2.add(Arrays.asList(0, 0, 0));
    arr2.add(Arrays.asList(0, 0, 0));
    arr2.add(Arrays.asList(0, 0, 0));
    System.out.println(md.minimumDays(3, 3, arr2));
  }
}
