package map;

import java.util.HashMap;
import java.util.Map;

/**
 * given a pattern: aaba see if: apple apple orange apple true matches
 *
 * @author john.lim
 */
public class StringInPattern {

    static boolean isMatch2(String a, String s) {
      String[] words = s.split(" ");
      if (a.length() != words.length) return false;

      Map<Character, Integer> hm = new HashMap<>();
      Map<Integer, Character> rev = new HashMap<>();
      for (int i = 0, k = 0; i < words.length; i++) {
        if (!hm.containsKey(a.charAt(i))) {
          rev.put(k, a.charAt(i));
          hm.put(a.charAt(i), k++);
        }
      }

      StringBuilder result = new StringBuilder();
      Map<String, Integer> hm2 = new HashMap<>();
      for (int i = 0, l = 0; i < words.length; i++) {
        if (!hm2.containsKey(words[i])) {
          hm2.put(words[i], l++);
        }
        result.append(rev.get(hm2.get(words[i])));
      }
      return result.toString().equals(a);
    }

  public static boolean isMatch(String pattern, String input) {
    char[] ch = pattern.toCharArray();
    String[] word = input.split(" ");
    if (ch.length != word.length) {
      return false;
    }
    Map<String, Character> map = new HashMap<>();
    for (int i = 0; i < word.length; i++) {
      if (!map.containsKey(word[i])) {
        map.put(word[i], ch[i]);
      } else {
        if (map.get(word[i]) != ch[i]) {
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String args[]) {
    // System.out.println(isMatch("aaba", "apple apple orange apple"));

    System.out.println(isMatch("aaaa", "dog apple apple dog"));
  }
}
