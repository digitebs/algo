package dp;

import java.util.Arrays;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int min[] = new int[amount + 1];
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) min[coins[i]] = 1;
    }

    if (amount == 0) return 0;

    for (int i = 1; i <= amount; i++) {
      int m = 0;
      for (int c : coins) {
        int f = i - c;
        if (f > 0 && min[f] > 0) {
          if (min[i] == 0) min[i] = min[f] + 1;
          else min[i] = Math.min(min[i], min[f] + 1);
        }
      }
      //  if(m!=0 && min[i] == 0) min[i] = m+1;
    }
    return min[amount] == 0 ? -1 : min[amount];
  }

  int minimalNumberOfCoins( int[] c,int n) {
    int[] dp = new int[n + 1]; // damn max; owkay?
    Arrays.fill(dp, 250);
    for(int i : c){
      dp[i] = 1;
    }
    for(int k = 0; k <= n ; k++){
      for(int i = 1; i <= k ; i++){
        if(dp[k-i]!=0)
          dp[k]=Math.min(dp[k-i] + dp[i],dp[k]);
      }

      //System.out.println(Arrays.toString(dp));
    }
    return dp[n];
  }

  public static void main(String[] args)
  {
    System.out.println(new CoinChange().coinChange(new int[] {1, 2, 5}, 11));
    System.out.println(new CoinChange().coinChange(new int[] {1, 2, 10}, 28));
    System.out.println(new CoinChange().minimalNumberOfCoins(new int[] {1, 2, 5}, 11));
    System.out.println(new CoinChange().minimalNumberOfCoins(new int[] {1, 2, 10}, 28));
  }
}
