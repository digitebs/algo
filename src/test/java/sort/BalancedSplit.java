package sort;

import java.util.Arrays;

/*
  Given an array of integers wth dup,
  determine if there's a way to split the array into two subarrays A and B such that the sum of the
  integers in both arrays is the same,
  and all of the integers in A are strictly smaller than all of the integers in B.

  Note: Strictly smaller denotes that every integer in A must be less than, and not equal to,
   every integer in B.

  arr = [1, 5, 7, 1]
  output = true

  arr = [12, 7, 6, 7, 6]
  output = false

  easy*

 */
class BalancedSplit {

  boolean balancedSplitExists(int[] arr) {
    Arrays.sort(arr);
    // 1,1,5,7
    // 3,3,4,4,6
    int n = arr.length;
    int s = 0, e = n - 1;
    int sum1 = 0, sum2 = 0;

    while (s < e) {
      System.out.printf("%4d %4d %4d %4d\n", sum1, sum2, s, e);
      if (sum1 <= sum2) {
        do sum1 += arr[s++];
        while (s < n && arr[s] == arr[s - 1]);
      } else if (sum1 > sum2) {
        do sum2 += arr[e--];
        while (e > 0 && arr[e] == arr[e + 1]);
      }
    }
    System.out.printf("%4d %4d %4d %4d\n", sum1, sum2, s, e);
    return (sum1 == sum2) ? true : false;
  }

  public static void main(String[] args) {
    BalancedSplit bs = new BalancedSplit();
    System.out.printf("%b\n", bs.balancedSplitExists(new int[] {2, 1, 2, 5}));
    System.out.printf("%b\n", bs.balancedSplitExists(new int[] {3, 6, 3, 4, 4}));
    System.out.printf("%b\n", bs.balancedSplitExists(new int[] {2, 2, 2, 2}));
  }
}
