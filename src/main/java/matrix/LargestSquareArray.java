package matrix;

import java.util.Scanner;

import static java.lang.System.out;

/** running time of this is O(n^2) */

/* Given a 2D binary matrix filled with 0's and 1's,
 find the largest square containing only 0's and return its area. */

public class LargestSquareArray {
  // check if subset

  private static int maxEmptySquare(int[][] arr, int[][] memo, int x, int y, int depth) {
    int d =
        Math.max(
            x - 1 >= 0 ? memo[x - 1][y] - 1 : 0,
            y - 1 >= 0 ? memo[x][y - 1] - 1 : 0); // starting dept, quick jump
    for (; d < depth; d++)
      for (int e = 0; e <= d; e++) {
        // out.println(x+" " +y+" "+d + " "+e +" "+ depth);
        if (arr[x + e][y + d] == 1 || arr[x + d][y + e] == 1) return (memo[x][y] = d);
      }
    return (memo[x][y] = d);
  }

  private static int largestSquareArray(int[][] arr, int m, int n) {
    int max = 0;
    int[][] memo = new int[m][n];
    for (int x = 0; x < m; x++)
      for (int y = 0; y < n && Math.min(m - x, n - y) > max; y++)
        max = Math.max(maxEmptySquare(arr, memo, x, y, Math.min(m - x, n - y)), max);
    return max * max;
  }

  public static void main(String[] args) {
    /* Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    int n = s.nextInt();
    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            arr[i][j] = s.nextInt();
        }
    }

    /*
        ==Copy & Paste==

        7 9
        0 1 1 1 1 0 0 0 1
        1 0 0 0 1 0 0 0 1
        0 0 1 0 0 0 0 0 1
        0 0 1 1 0 0 0 0 1
        1 1 0 1 0 0 0 0 1
        1 0 0 1 0 0 0 1 0
        0 0 0 1 1 0 0 0 1

    out.println(largestSquareArray(arr, m, n));

    */

    // ==Samples==
    out.println(
        largestSquareArray(
            new int[][] {
              {1, 1, 1, 1, 1, 1, 1, 1, 1},
              {1, 0, 0, 0, 0, 0, 0, 0, 1},
              {1, 0, 0, 0, 0, 1, 0, 0, 1},
              {1, 0, 0, 0, 0, 0, 0, 0, 1},
              {1, 0, 0, 0, 0, 0, 0, 0, 1},
              {1, 0, 0, 0, 0, 0, 0, 0, 1},
              {1, 0, 0, 0, 0, 0, 0, 0, 1}
            },
            7,
            9));

    out.println(
        largestSquareArray(
            new int[][] {
              {0, 1, 1, 1, 1, 0, 0, 0, 1},
              {1, 0, 0, 0, 1, 0, 0, 0, 1},
              {0, 0, 1, 0, 0, 0, 0, 0, 1},
              {0, 0, 1, 1, 0, 0, 0, 0, 1},
              {1, 1, 0, 1, 0, 0, 0, 0, 1},
              {1, 0, 0, 1, 0, 0, 0, 1, 0},
              {0, 0, 0, 1, 1, 0, 0, 0, 1}
            },
            7,
            9));

    out.println(
        largestSquareArray(
            new int[][] {
              {1, 0, 0},
              {0, 0, 0},
              {0, 1, 1}
            },
            3,
            3));

    out.println(
        largestSquareArray(
            new int[][] {
              {1, 0, 0, 0, 0},
              {1, 0, 0, 0, 0},
              {1, 0, 0, 0, 0},
              {0, 0, 0, 0, 1}
            },
            4,
            5));

    out.println(
        largestSquareArray(
            new int[][] {
              {1, 0, 0, 0, 0},
              {1, 0, 0, 0, 0},
              {1, 0, 0, 0, 0},
              {0, 0, 0, 0, 0}
            },
            4,
            5));

    out.println(
        largestSquareArray(
            new int[][] {
              {1, 0, 0, 1, 0},
              {1, 0, 1, 0, 0},
              {1, 0, 0, 1, 0},
              {0, 0, 1, 0, 0}
            },
            4,
            5));

    out.println(
        largestSquareArray(
            new int[][] {
              {1, 0, 0, 1, 0},
              {1, 0, 1, 0, 0},
              {1, 0, 0, 0, 0},
              {0, 0, 1, 0, 0}
            },
            4,
            5));

    out.println(largestSquareArray(new int[][] {{1}}, 1, 1));
    out.println(largestSquareArray(new int[][] {{0}}, 1, 1));
  }
}
