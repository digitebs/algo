package array;

import java.util.Arrays;

public class kDifference {
  static int kDifference(int[] a, int k) {
    Arrays.sort(a);
    int ctr = 0;
    for (int i = a.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (a[i] - a[j] == k) ctr++;
      }
    }
    return ctr;
  }

  public static void main(String args[]) {
    System.out.println(kDifference(new int[] {1, 3, 5}, 2));
  }
}
