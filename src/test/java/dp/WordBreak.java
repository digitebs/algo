package dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

  /*
     Interesting use of dp by checking each time if a substring is match
     update the upto length in dp
  */
  public boolean wordBreak(String s, List<String> wordDict) {
    // if (pos >= wordDict.size()) return false;
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      if (!dp[i - 1]) continue;
      for (int j = i; j <= n; j++) {
        if (wordDict.contains(s.substring(i - 1, j))) {
          dp[j] = true;
        }
      }
      if (dp[n]) break;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(
        new WordBreak()
            .wordBreak(
                "bccdbacdbdacddabbaaaadababadad",
                Arrays.asList(
                    "cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd",
                    "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd",
                    "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a", "bbcc", "cdcbd", "cada",
                    "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc",
                    "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb")));
  }
}
