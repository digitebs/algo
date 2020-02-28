package matrix;

import model.Point;
import model.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n^2 where we ini initialize an empty array, point the row reference to same array if there is no
 * 0 found.
 */
public class ZeroMatrix {

  private static int[][] zeroMatrix(int[][] arr) {
    int n = arr.length;
    int m = arr[0].length;
    int[][] res = new int[n][m];
    for (int i = 0; i < n; i++) {
      boolean z = false;
      for (int j = 0; j < m && !z; j++) if (arr[i][j] == 0) z = true;
      if (!z) res[i] = arr[i]; // put a reference
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] arr = {{1, 1, 2}, {1, 0, 1}, {1, 2, 0}};
    // System.out.println(Arrays.deepToString(zeroMatrix(arr)));
    int[][] arr2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    System.out.println(Arrays.deepToString(setZeroes2(arr2)));
  }

  static int[][] setZeroes(int[][] matrix) {
    List<Point> points = new ArrayList<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) points.add(new Point(i, j)); // point with zero
      }
    }

    for (Point point : points) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[point.x][i] = 0;
      }
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][point.y] = 0;
      }
    }
    return matrix;
  }

  static int[][] setZeroes2(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    Boolean isCol = false;
    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 0) {
        isCol = true;
      }
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // 1st row
    if (matrix[0][0] == 0) {
      for (int j = 0; j < m; j++) {
        matrix[0][j] = 0;
      }
    }

    // 1st column
    if (isCol) {
      for (int i = 0; i < n; i++) {
        matrix[i][0] = 0;
      }
    }
    return matrix;
  }
}
