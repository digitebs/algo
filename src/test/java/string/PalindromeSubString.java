package string;

public class PalindromeSubString {
  static boolean isPalindrome(String s, Boolean[][] memo, int i, int j, int n) {
    if (memo[i][j] != null) return memo[i][j];

    for (int k = n / 2 - 1; k >= 0; k--) {
      int start = i + k, end = i + n - 1 - k;
      memo[start][end] = true;
      if (s.charAt(start) != s.charAt(end)) return memo[start][end] = false;
    }
    return true;
  }

  static String longestPalindrome(String s) {
    int max = 0;
    String ans = "";
    int n = s.length();
    Boolean[][] memo = new Boolean[n][n];

    for (int i = 0; i < s.length(); i++)
      for (int j = s.length(); j > i; j--) { // min 2 chars
        int len = j - i;
        if (len > max && isPalindrome(s, memo, i, j - 1, len)) {
          max = len;
          ans = s.substring(i, j);
        }
      }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("abba"));
  }
}
