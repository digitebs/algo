package dp;

import java.util.Arrays;


/*
    medium*
# array coins and N
# return the number of ways to can  the change using the coins. coins can be repeated
 */
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
    for (long a : c) {
      for (int j = (int)a; j <= n; j++) {
        dp[j] = dp[j] + dp[j - (int) a];
        // System.out.print(Arrays.toString(dp));
      }
      //System.out.println(Arrays.toString(dp));
    }
    return dp[(int) n];
  }

  public static void main(String[] args) {
    System.out.println(getWays(5, new long[] {2, 3}));
    System.out.println(getWays(5, new long[] {1, 2}));
    System.out.println(getWays(11, new long[] {1, 2,5}));
    System.out.println(getWays(5, new long[] {1, 2}));
    System.out.println(getWays(7, new long[] {1, 2}));
    System.out.println(getWays(4, new long[] {1, 2,3}));
    System.out.println(getWays(8, new long[] {1, 2,4}));
  }
}
