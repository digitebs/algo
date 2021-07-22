package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/*
  given a string, find the longets substring that has no dup
 */
public class LongestSubstringNoDup {
  // using hashmap to store dup index
  // a b c d e f g h c a
  static int longestsub(String str) {
    int maxLen = 0;
    int start = -1;
    HashMap<Character, Integer> hm = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      start = Math.max(start, hm.getOrDefault(c, start));
      maxLen = Math.max(i - start, maxLen);
      hm.put(c, i); // update the index
    }
    return maxLen;
  }

  static int longestsub3(String s) {
    int[] index = new int[256];
    Arrays.fill(index,-1);
    int max = 0;
    int j = -1;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      j = Math.max(j,index[c]);
      max = Math.max(max, i -j);
      index[c] = i;
    }
    return max;//= Math.max(max, s.length() - j);
  }

  // a b c d b c a f
  // sliding window, at least 2(n) due to backtrack removal
  static int longestsub2(String str) {
    int res = 0, right = 0, left = 0;
    Set<Character> hs = new HashSet<>();
    while (right < str.length()) {
      if (hs.contains(str.charAt(right))) {
        hs.remove(str.charAt(left++));
      } else {
        hs.add(str.charAt(right++));
        res = Math.max(hs.size(), res);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(longestsub("ABCDEFAGYTUIKGE"));
    System.out.println(longestsub("ABCDEFGE"));
    System.out.println(longestsub("aA"));
    System.out.println(longestsub("abcaacefgh"));
    System.out.println(longestsub("abcdacefgh"));
    System.out.println(longestsub("abdaeedfg"));
    System.out.println(longestsub("ninenine"));
    System.out.println(longestsub2("faaaaaaaaaaaf"));
    System.out.println(longestsub("au"));

    System.out.println("~$ " + longestsub3("a"));
    System.out.println("~$ " + longestsub3("au"));
    System.out.println("~$ " + longestsub3("bdb"));
    System.out.println("~$ " + longestsub3("aa"));
    System.out.println("~$ " + longestsub3("dvdf"));
    System.out.println("~$ " + longestsub3("tmmzuxt"));
    System.out.println("~$ " + longestsub3("tmmzuxtmbcdegtmbcdekgt"));
    System.out.println("~$ " + longestsub3("abcabcbb"));
    System.out.println("~$ " + longestsub3("nfpdmpi"));
    System.out.println("~$ " + longestsub3("uqinntq"));
  }
}
