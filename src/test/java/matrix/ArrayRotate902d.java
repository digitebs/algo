package matrix;

import java.util.Arrays;

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
  static int[][] rotate(int[][] arr) {
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) { // layer
      for (int j = i; j < n - 1 - i; j++) { // next
        int temp = arr[i][j];
        arr[i][j] = arr[n - 1 - j][i];
        arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
        arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
        arr[j][n - 1 - i] = temp;
      }
    }
    return arr;
  }

  /* using new array */
  private int[][] rotateMatrix(int[][] src) {
    int[][] img = new int[src.length][src.length];

    for (int i = 0; i < src.length; i++) {
      for (int j = 0; j < src.length; j++) {
        img[i][j] = src[src.length - 1 - j][i];
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
    System.out.println(Arrays.deepToString(rotate(arr)));
    arr = new int[][] {{1, 2}, {3, 4}};
    System.out.println(Arrays.deepToString(rotate(arr)));
    arr = new int[][] {{1}};
    System.out.println(Arrays.deepToString(rotate(arr)));
  }
}
