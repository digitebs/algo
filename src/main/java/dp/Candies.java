package dp;

import java.util.Arrays;

/*
  There are N children standing in a line. Each child is assigned a rating value.

  You are giving candies to these children subjected to the following requirements:

  Each child must have at least one candy.
  Children with a higher rating get more candies than their neighbors.
  What is the minimum candies you must give?

  Input: [1,0,2]
  Output: 5
  Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 */
public class Candies {

  // linear reverse traversal
  // 1 2 3 3 2 1
  // 1 1 1 1 1 1
  // 1 2 3 1 1 1
  // 1 2 4 3 2 1

  // 4 3 2 1
  // 1 1 1 1
  // 4 3 2 1
  static long candies(int n, int[] arr) {
    long[] memo = new long[n];
    Arrays.fill(memo, 1L);
    for (int i = 1; i < n; i++) if (arr[i - 1] < arr[i]) memo[i] = memo[i - 1] + 1;
    for (int i = n - 2; i >= 0; i--)
      if (arr[i] > arr[i + 1]) if (memo[i] <= memo[i + 1]) memo[i] = memo[i + 1] + 1;
    System.out.println(Arrays.toString(arr));
    return Arrays.stream(memo).sum();
  }

  public static void main(String[] args) {
    System.out.println(candies(6, new int[] {1, 2, 3, 3, 2, 1}));
  }
}
