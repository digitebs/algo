package regex;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support
 * for '.' and '*'.
 *
 * <p>'.' Matches any single character. '*' Matches zero or more of the preceding element.
 *
 * @see graph.GraphRegex
 */
public class RegexPattern {
  /*
     uses recursion
  */
  static boolean isMatch(String text, String pattern, int i, int j) {
    // System.out.println(i + " " + text.substring(i) + " " + pattern.substring(j) + " " + j);
    if (j >= pattern.length()) return i == text.length();

    if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
      return isMatch(text, pattern, i, j + 2)
          || i < text.length()
              && ((pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i))
                  && isMatch(text, pattern, i + 1, j));
    }

    return i < text.length()
        && (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i))
        && isMatch(text, pattern, i + 1, j + 1);
  }

  static boolean isMatch(String text, String pattern) {
    return isMatch(text, pattern, 0, 0);
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

    System.out.println(isMatch("ab", ".*c"));
    System.out.println(isMatch("aa", "a*"));
    System.out.println(isMatch("mississippi", "mis*is*p*."));
    //  System.out.println(isMatch("abbbbaz", "a.*a*"));
    // System.out.println(isMatch("abbbbaz", "ab*a*"));
  }
}
