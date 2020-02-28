package matrix;

import java.util.Arrays;

/*
  You are given an n x n 2D matrix that represents an image.

 */
public class ArrayRotate902d {

  // 1 2 3 4
  // 5 6 7 8
  // 9 10 11 12
  // 13 14 15 16

  // 13 9 5 1
  // 14 10 6 2
  // 15 11 7 3
  // 16 12 8 4

  // can be done by layer inplace
  static int[][] rotate(int[][] a) {
    int n = a.length - 1;
    for (int i = 0; i <= n / 2; i++) {
      for (int j = i; j < n - i; j++) {
        int temp = a[i][j];
        a[i][j] = a[n - j][i];
        a[n - j][i] = a[n - i][n - j];
        a[n - i][n - j] = a[j][n - i];
        a[j][n - i] = temp;
      }
    }
    return a;
  }

  /* using new array */
  static int[][] rotateMatrix(int[][] a) {
    int[][] img = new int[a.length][a.length];
    int n = a.length - 1;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        img[i][j] = a[n - j][i];
        System.out.print(img[i][j] + " ");
      }
      System.out.print("\n");
    }
    return img;
  }

  public static void main(String[] args) {
    int[][] arr = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    System.out.println(Arrays.deepToString(rotate(arr)));
    arr = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(Arrays.deepToString(rotateMatrix(arr)));
    arr = new int[][] {{1, 2}, {3, 4}};
    System.out.println(Arrays.deepToString(rotate(arr)));
    arr = new int[][] {{1}};
    System.out.println(Arrays.deepToString(rotate(arr)));
  }
}
