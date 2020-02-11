package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Created by johnlim on 1/2/17. */
public class LeetCodeString {

  @Test
  public void lengthOfLongestSubstring() {
    System.out.println("~$ " + lengthOfLongestSubstring("a"));
    System.out.println("~$ " + lengthOfLongestSubstring("au"));
    System.out.println("~$ " + lengthOfLongestSubstring("bdb"));
    System.out.println("~$ " + lengthOfLongestSubstring("aa"));
    System.out.println("~$ " + lengthOfLongestSubstring("dvdf"));
    System.out.println("~$ " + lengthOfLongestSubstring("tmmzuxt"));
    System.out.println("~$ " + lengthOfLongestSubstring("tmmzuxtmbcdegtmbcdekgt"));
    System.out.println("~$ " + lengthOfLongestSubstring("abcabcbb"));
    System.out.println("~$ " + lengthOfLongestSubstring("nfpdmpi"));
    System.out.println("~$ " + lengthOfLongestSubstring("uqinntq"));
  }

  public int lengthOfLongestSubstring(String s) {
    int[] index = new int[256];
    for (int i = 0; i < index.length; i++) {
      //index[i] = -1;
    }
    int max = 0;
    int len = 0;
    int j = -1;

    if (s.length() == 0) return 0;
    if (s.length() == 1) return 1;
    for (int i = 0; i < s.length(); i++) {

      // System.out.println(ctr);
      //if (index[s.charAt(i)] != -1 && index[s.charAt(i)] > j) {
        // index[s.charAt(j)] = -1;

       // System.out.println(i + " "+j);
       // len = i - j;
       // max = Math.max(max, len);
        // index = new int[256];
        // i=++j;
      char c = s.charAt(i);
        j = Math.max(j,Math.max(index[c],j));
       // System.out.println(i + " + "+j);
        //  index[s.charAt(i)] = i;
     //   System.out.println(
       //     i + " " + j + " " + s.charAt(j) + " " + index[s.charAt(j)] + " " + ctr + " " + len);
      //}
      max = Math.max(max, i -j);
      index[c] = i;
    }
   // System.out.println("j:" + j + " " + len + " " + s.length() + " " + index[s.charAt(j)]);
    return max;//= Math.max(max, s.length() - j);
  }

}
