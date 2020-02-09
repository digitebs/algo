package dp;

import java.util.ArrayList;
import java.util.List;

/*
Given a positive integer n, find the least number of perfect square numbers
(for example, 1, 4, 9, 16, ...) which sum to n.

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
 */
public class PerfectSquares {
  int numSquares(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int j = 2; j <= n; j++) {
      dp[j] = Integer.MAX_VALUE;
      for (int i = 1; i * i <= j; i++) {
        dp[j] = Math.min(dp[j], 1 + dp[j - i * i]);
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(new PerfectSquares().numSquares(13));
  }
}
