package regex;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support
 * for a-z, '.' and '*'.
 *
 * <p>'.' Matches any single character. '*' Matches zero or more of the preceding element.
 *
 * @see graph.GraphRegex
 */
public class RegexPattern {
  /*
     uses recursion
  */
  int[][] dp;

  boolean match(String s, String p, int i, int j) {
    if (dp[i][j] != 0) {
      return dp[i][j] == 1;
    }

    if (j == p.length() && s.length() == i) {
      return true;
    }
    if (j == p.length()) {
      return false;
    }

    char b = p.charAt(j);
    if (b == '*') {
      while (j < p.length() - 1 && p.charAt(j + 1) == '*') j++;
      for (int k = i; k <= s.length(); k++) {
        if (match(s, p, k, j + 1)) {
          dp[i][j] = 1;
          return true;
        }
      }
    } else if (i < s.length()) {

      char a = s.charAt(i);
      if (a == b || b == '?') {
        //  System.out.println(a+" "+b);
        if (match(s, p, i + 1, j + 1)) {
          dp[i][j] = 1;
          return true;
        }
      }
    }
    dp[i][j] = -1;
    return false;
  }

  boolean isMatch(String s, String p) {
    dp = new int[s.length() + 1][p.length() + 1];
    return match(s, p, 0, 0);
    /*int i = 0, j = 0;
    if (j >= pattern.length()) return i == text.length();
    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
        return isMatch(text, pattern.substring(j+2))
                || i < text.length()
                && ((pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i))
                && isMatch(text.substring(i+1), pattern));
    }
    return i < text.length()
        && (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i))
        && isMatch(text.substring(++i), pattern.substring(++j));*/
  }

  public static void main(String[] args) {
    //  System.out.println(isMatch("acd", "ab*c."));
    RegexPattern rp = new RegexPattern();
    System.out.println(rp.isMatch("ab", ".*c"));
    System.out.println(rp.isMatch("aa", "a*"));
    System.out.println(rp.isMatch("aa", "*"));
    System.out.println(rp.isMatch("mississippi", "mis*is*p*."));
    //  System.out.println(isMatch("abbbbaz", "a.*a*"));
    // System.out.println(isMatch("abbbbaz", "ab*a*"));
  }
}
