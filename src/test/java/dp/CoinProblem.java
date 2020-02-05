package dp;

import java.util.Arrays;

public class CoinProblem {

  // if its sorted can just overlapped 2d array
  // 0 1 2 3 4 5
  // 0 0 1 1 1 1
  // 0 0 0 1 1 1
  // 0 0 0 1 2 2
  static long getWays(long n, long[] c) {
    long[] dp = new long[(int) n + 1]; // damn max; owkay?
    dp[0] = 1; // / takes 1 on zero
    Arrays.sort(c); // sort c so we can do change properly
    for (long a : c)
      for (int j = 1; j <= n; j++) {
        if (j >= a) dp[j] = dp[j] + dp[j - (int) a];
        // System.out.print(Arrays.toString(dp));
      }

    return dp[(int) n];
  }

  public static void main(String[] args) {
    System.out.println(getWays(5, new long[] {2, 3}));
  }
}
