package dp;

import java.util.Arrays;

/*
  [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
   [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1],
       [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1],
        [0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2],
         [0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2],
          [0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2],
           [0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2],
            [0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2]]


Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.



If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {
  // longest common subsequence of 2 string
  static int common(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    int[][] memo = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) memo[i][j] = memo[i - 1][j - 1] + 1;
        else memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
      }
    }

    return memo[m][n];
  }

  public static void main(String[] args) {
    System.out.println(common("OUDFRMYMAW", "AWHYFCCMQX"));
  }
}
