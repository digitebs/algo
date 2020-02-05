package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

  // a b c d b c a f
  // sliding window, at least 2(n) due to backtrack removal
  static int longestsub3(String str) {
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

  // longestsub2 similar variation of longestsub, move the start to where theres no duplicate
  static int longestsub2(String s) {

    HashMap<Character, Integer> hm = new HashMap<>(); // we store teh caharcter of string
    int ans = 0;
    for (int i = 0, start = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (hm.containsKey(c)) {
        start = Math.max(hm.get(c), start); // i is upto where
      }
      ans = Math.max(ans, i - start + 1);
      hm.put(c, i + 1); // update the character last position
    }
    return ans;
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
  }
}
