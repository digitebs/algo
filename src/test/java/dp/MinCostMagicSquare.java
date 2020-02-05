package dp;

import java.util.function.ToIntBiFunction;

import static java.lang.Math.abs;
import static java.lang.System.out;

/**
 * We define a magic square to be an matrix of distinct positive integers from to where the sum of
 * any row, column, or diagonal of length is always equal to the same number: the magic constant.
 */
public class MinCostMagicSquare {
  static int square(int[][] s) {

    int[][][] states = {
      {
        {4, 9, 2},
        {3, 5, 7},
        {8, 1, 6}
      },
      {
        {6, 1, 8},
        {7, 5, 3},
        {2, 9, 4}
      },
      {
        {8, 1, 6},
        {3, 5, 7},
        {4, 9, 2}
      },
      {
        {8, 3, 4},
        {1, 5, 9},
        {6, 7, 2}
      },
      {
        {4, 3, 8},
        {9, 5, 1},
        {2, 7, 6}
      },
      {
        {2, 7, 6},
        {9, 5, 1},
        {4, 3, 8}
      },
      {
        {6, 7, 2},
        {1, 5, 9},
        {8, 3, 4}
      },
      {
        {2, 9, 4},
        {7, 5, 3},
        {6, 1, 8}
      },
    };

    ToIntBiFunction<int[][], int[][]> tobf =
        (a, b) -> {
          int cost = 0;
          for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
              if (a[i][j] != b[i][j]) cost += abs(a[i][j] - b[i][j]);

          return cost;
        };
    int min = 9 * 9;
    for (int i = 0; i < states.length; i++) min = Math.min(min, tobf.applyAsInt(states[i], s));

    return min;
  }

  public static void main(String[] args) {
    out.println(
        MinCostMagicSquare.square(
            new int[][] {
              {4, 9, 2},
              {3, 5, 7},
              {8, 1, 5}
            }));
  }
}
