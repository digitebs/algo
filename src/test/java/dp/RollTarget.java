package dp;

import java.util.Arrays;

/*

You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7
 to roll the dice so the sum of the face up numbers equals target.
 */
public class RollTarget {
    static int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d+1][d*f + 1];
        if (target > d*f)
            return 0;
        for (int i = 1; i <= f; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= d;i++) {
            for (int j = i; j <= i*f; j++) {
                for (int k = 1; k <= f;k++) {
                    if (k >= j) break;
                    dp[i][j] += dp[i-1][j-k];
                }
                dp[i][j] = dp[i][j]%1000000007;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return (int)dp[d][target];
    }

  public static void main(String[] args) {
    // 4 = 3 + 1
      // 2 + 2
      // 1 + 3
      System.out.println(numRollsToTarget(3,4,4));
  }
}
