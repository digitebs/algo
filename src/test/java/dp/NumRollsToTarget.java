package dp;

/**
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.
 *
 * Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so
 * the sum of the face up numbers equals target.
 *
 */
public class NumRollsToTarget {
  static int numRollsToTarget(int d, int f, int target) {
    long[][] dp = new long[d + 1][d * f + 1];
    long exp = (long) 1e9 + 7; // technique to add 00000000 at the end
    if (target > d * f) return 0;
    for (int i = 1; i <= f; i++) dp[1][i] = 1;

    for (int i = 2; i <= d; i++) {
      for (int j = i; j <= i * f; j++) {
        if (j >= 1) {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
        }
        if (j >= f + 1) {
          dp[i][j] -= dp[i - 1][j - f - 1];
        }
        dp[i][j] %= exp;
        if (dp[i][j] < 0) {
          dp[i][j] += exp;
        }
      }
      // System.out.println(Arrays.deepToString(dp));
    }
    return (int) dp[d][target];
  }

  public static void main(String[] args) {
    //
    System.out.println(numRollsToTarget(1, 6, 3));
    System.out.println(numRollsToTarget(2, 6, 7));
    System.out.println(numRollsToTarget(2, 5, 10));
    System.out.println(numRollsToTarget(5, 3, 11));
  }
}
