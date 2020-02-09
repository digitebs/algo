package string;

import java.util.Arrays;

/**
 Input:
 ["a","a","b","b","c","c","c"]

 Output:
 Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

 Explanation:
 "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 */
public class StringCompression {
  static String compression(String s1) {
    StringBuilder res = new StringBuilder().append(s1.charAt(0));
    int cons = 0;
    for (int i = 1; i < s1.length(); i++) {
      cons++;
      if (s1.charAt(i) != s1.charAt(i - 1)) {
        res.append(cons).append(s1.charAt(i));
        cons = 0; // set it to1
      }
    }
    res.append(++cons);
    return res.length() < s1.length() ? res.toString() : s1;
  }

  /*
   Given an array of characters, compress it in-place.
  */
  static int compression(char[] chars) {
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

    System.out.println(compression("aabcccccaaa".toCharArray()));
    System.out.println(compression("ab".toCharArray()));
  }
}
