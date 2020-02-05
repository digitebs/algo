package dp;

public class NumEncoding {

  public int numDecodings(String s) {
    int[] dp = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i] +=
          s.charAt(i) > '0'
              ? i - 1 < 0 ? 1 : dp[i - 1]
              : i > 0 && (s.charAt(i - 1) == '2' && s.charAt(i) < '7' || s.charAt(i - 1) == '1')
                  ? dp[i] += (i - 2 < 0) ? 1 : dp[i - 2]
                  : 0;
    }
    return s.isEmpty() ? 0 : dp[s.length() - 1];
  }
}
