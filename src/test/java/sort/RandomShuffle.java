package sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class  RandomShuffle {

  // 3 x 3
  // deterministic shuffle
  // the trick is to flatten the random instead of 2 values into 1
  // O(n^2)
  static void shuffle(char[][] arr, int b) {
    int n = arr.length, m = arr[0].length;
    List<Integer> list = IntStream.range(0, n * m).boxed().collect(Collectors.toList());
    // for (int i = 0; i < n * m; i++) list.add(i); // boot it up 0 - 8
    Random r = new Random();
    while (b-- > 0) {
      int i = list.remove(r.nextInt(list.size())); // remove the object itself
      arr[i / n][i % m] = '*';
    }
  }
  // Fisher - Yates
  static void shuffle2(char[][] arr, int b) {
    int n = arr.length, m = arr[0].length;
    List<Integer> list = IntStream.range(0, n * m).boxed().collect(Collectors.toList());
    Random r = new Random();
    int i = list.size();
    while (b-- > 0) {
      Collections.swap(list, --i, r.nextInt(i));
      int idx = list.get(i);
      arr[idx / n][idx % m] = '*';
    }
  }

  static void shuffle3(char[][] arr, int b) {
    int n = arr.length, m = arr[0].length;
    List<Integer> list = IntStream.range(0, n * m).boxed().collect(Collectors.toList());
    Collections.shuffle(list);
    int i = list.size();
    while (b-- > 0) {
      int idx = list.get(--i);
      arr[idx / n][idx % m] = '*';
    }
  }

  // mineweeper bomb
  static void bomb(char[][] grid, int k) {

    int n = grid.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n * n; i++) list.add(i < k ? 1 : 0);
    Collections.shuffle(list);
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 1) {
        int col = i % n;
        int row = i / n;
        grid[row][col] = '*';
      }
    }
  }

  public static void main(String[] args) {
    char[][] c = new char[3][3];
    bomb(c, 5);
    for (char[] a : c) System.out.println(Arrays.toString(a));
  }
}
