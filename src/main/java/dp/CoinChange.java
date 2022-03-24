package dp;

import java.util.Arrays;

public class CoinChange {

  public int coinChange2(int[] coins, int amt) {
      int[] dp=new int[amt+1];
      Arrays.fill(dp,amt+1);
      dp[0]=0;
      for(int c:coins){
        for(int i=c;i<=amt;i++){
          dp[i]=Math.min(dp[i],dp[i-c]+1);
        }
      }
      return dp[amt]==amt+1?-1:dp[amt];
  }

  public int coinChange(int[] coins, int amount) {
    int[] min = new int[amount + 1];
    Arrays.fill(min,-1);
    if (amount == 0) return 0;


    for (int c : coins) {
      for (int i = c; i <= amount; i++) {
        min[c] = 1;
        int r = i - c;
       // if ( min[r] != 0) {
          if (min[i] == 0) min[i] = min[r] + 1;
          else min[i] = Math.min(min[i], min[r] + 1);
        //}
      }
      //  if(m!=0 && min[i] == 0) min[i] = m+1;
    }
    return min[amount] == 0 ? -1 : min[amount];
  }

  int minimalNumberOfCoins( int[] c,int n) {
    int[] dp = new int[n + 1]; // damn max; owkay?
    Arrays.fill(dp, 999);
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
