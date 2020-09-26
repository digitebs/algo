package string;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/*
You are given two strings s and t. You can select any substring of string s and rearrange the
characters of the selected substring. Determine the minimum length of the substring of s
such that string t is a substring of the selected substring.

  s = "dcbefebce"
  t = "fd"'
  output = 5
  Explanation:
  Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb".

  medium*
  Thus, the minimum length required is 5.
 */
class MinLengthSubstring {

  // O(n)
  int minLengthSubstring(String s, String t) {

    HashMap<Character, Integer> hm = new HashMap<>();
    for (char ch : t.toCharArray()) {
      hm.put(ch, hm.getOrDefault(ch, 0) + 1); // store all chars?
    }

    int min = Integer.MAX_VALUE;
    int limit = t.length();
    int c=0;
    Deque<Integer[]> q = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int count = hm.getOrDefault(ch, -1);

      if (count <= 0 && limit != q.size()) ;// have you reach the limit???
      else {

        if (limit == q.size()) {
          if (q.peek()[0].intValue() != (int) ch) continue;
          q.pop();
        } else {
          hm.put(ch, count - 1); // store all chars?
        }

        q.offer(new Integer[] {(int) ch, i});
        //q.forEach(x -> System.out.print((char) x[0].intValue()));
        //System.out.println();
        if (limit == q.size()) {
          min = Math.min(min, q.getLast()[1] - q.peek()[1] + 1);
        }
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }

  public static void main(String[] args) {
    MinLengthSubstring mls = new MinLengthSubstring();
    System.out.println(mls.minLengthSubstring("abfdeghijkflmf", "ff"));
    System.out.println(mls.minLengthSubstring("dcbefebce", "fd"));
    System.out.println(mls.minLengthSubstring("bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf",
                                              "cbccfafebccdccebdd"));

  }

}
