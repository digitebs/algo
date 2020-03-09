package string;

import java.util.Arrays;

/**
 * Input: ["a","a","b","b","c","c","c"]
 *
 * <p>Output: Return 6, and the first 6 characters of the input array should be:
 * ["a","2","b","2","c","3"]
 *
 * <p>Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 */
public class StringCompression {
  String compression(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0, count = 1; i < s.length(); i++, count++) {
      if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
        if (count > 1) sb.append(count);
        sb.append(s.charAt(i));
        count = 0;
      }
    }
    return sb.length() <= s.length() ? sb.toString() : s;
  }

  /*
   Given an array of characters, compress it in-place.
  */
   int compression(char[] chars) {
    // StringBuilder res = new StringBuilder().append(s1.charAt(0));
    int p = 0, count = 0;
    for (int i = 0; i < chars.length; i++) {
      count++;
      if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
        chars[p++] = chars[i];
        if (count > 1) {
          char[] counts = Integer.toString(count).toCharArray();
          for (int j = 0; j < counts.length; j++) {
            chars[p++] = counts[j];
          }
        }
        count = 0; // set it to1
      }
    }
    return p;
  }

  public static void main(String[] args) {

    StringCompression sc = new StringCompression();
    System.out.println(sc.compression("aabcccccaaa".toCharArray()));
    System.out.println(sc.compression("ab".toCharArray()));
    System.out.println(sc.compression("aabbbc"));
  }
}
