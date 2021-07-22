package string;

import java.util.HashMap;

/*
  given 2 string, count the number of equal characters you are allowed to swap an index once.

  s = "abcd"
  t = "adcb"
  output = 4
  Explanation:
  Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".

 */
public class MatchingPairs {

  int solve(String s, String t) {
    // Write your code here
    char[] b1 = s.toCharArray();
    char[] b2 = t.toCharArray();
    int n = b1.length;

    HashMap<Character, Character> hs = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (b1[i] != b2[i]) hs.put(b1[i], b2[i]);
    }

    int c = 0;
    int found = -2;
    for (int i = 0; i < n; i++) {
      if (b1[i] == b2[i]) {
        c++;
      } else if (found == -2 && b1[i] == hs.getOrDefault(b2[i], '\0')) {
        c += found = 2;
      }
    }

    /*
     edge cases
    */
    return c + Math.min(found + n - c, 0);
  }

  public static void main(String[] args) {
    String s1 = "abcd", t1 = "adcb";
    String s2 = "mno", t2 = "mno";
    String s3 = "abcde", t3 = "adcbe";
    String s4 = "abcd", t4 = "abcd";
    String s5 = "abcd", t5 = "efgh";
    String s6 = "abcd", t6 = "abce";
    String s7 = "abczz", t7 = "abcee";
    String s8 = "abczzf", t8 = "abceeq";

    MatchingPairs mp = new MatchingPairs();

    System.out.println(mp.solve(s1, t1));
    System.out.println(mp.solve(s2, t2));
    System.out.println(mp.solve(s3, t3));
    System.out.println(mp.solve(s4, t4));
    System.out.println(mp.solve(s5, t5));
    System.out.println(mp.solve(s6, t6));
    System.out.println(mp.solve(s7, t7));
    System.out.println(mp.solve(s8, t8));
  }
}
