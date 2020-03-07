package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
For words = ["crossword", "square", "formation", "something"], the output should be

6.

 f                         f                             f
  o                     c r o s s w o r d     c r o s s w o r d
c r o s s w o r d           r   o                   q     r
  m   q                     m   m                   u     m
  a   u            ;  s q u a r e          ;        a     a
  t   a                     t   t                   r     t
  i   r                     i   h             s o m e t h i n g
s o m e t h i n g           o   i                         o
  n                         n   n                         n
                                g

    c         s               s
f o r m a t i o n       c     q               c         s
    o         m         r     u               r         o
    s q u a r e       f o r m a t i o n       o         m
    s         t    ;    s     r            ;  s q u a r e
    w         h         s o m e t h i n g     s         t
    o         i         w                     w         h
    r         n         o                   f o r m a t i o n
    d         g         r                     r         n
                        d                     d         g


 */
public class CrossWordSquare {

  public static void main(String[] args) {

    CrossWordSquare cws = new CrossWordSquare();
    // System.out.println(cws.crosswordFormation(new String[] {"abca","aefa","aiha","alka"}));
    //  System.out.println(
    //        cws.crosswordFormation(new String[] {"crossword", "square", "formation",
    // "something"}));
    //  System.out.println(cws.crosswordFormation(new String[] {"external", "texas", "chainsaw",
    // "massacre"}));

    System.out.println(
        cws.crosswordFormation(new String[] {"africa", "america", "australia", "antarctica"}));
    //
  }

  int crosswordFormation(String[] words) {
    res = new ArrayList<>();
    combine(words, 0);
    int count = 0;
    for (String[] r : res) {
      for (int topend = 0; topend < r[0].length(); topend++) { // hor
        for (int rightstart = 0; rightstart < r[1].length(); rightstart++) {
          if (r[1].charAt(rightstart) != r[0].charAt(topend)) continue;
          for (int rightend = rightstart + 1; rightend < r[1].length(); rightend++) {
            for (int bottomend = r[2].length() - 1; bottomend >= 0; bottomend--) {
              if (r[2].charAt(bottomend) != r[1].charAt(rightend)) continue;
              for (int bottomstart = bottomend - 1; bottomstart >= 0; bottomstart--) { // hor
                for (int leftend = r[3].length() - 1; leftend >= 0; leftend--) {
                  if (r[3].charAt(leftend) != r[2].charAt(bottomstart)) continue;
                  int hlength = bottomend - bottomstart;
                  int vlength = rightend - rightstart;
                  int leftstart = leftend - vlength;
                  int topstart = topend - hlength;
                  if (leftstart < 0 || topstart < 0) continue;
                  if (r[0].charAt(topstart) == r[3].charAt(leftstart)
                      && hlength != 1
                      && vlength != 1) {
                    count++;
                  }
                }
              }
            }
          }
        }
      }
    }
    return count;
  }

  String[] swap(String[] arr, int i, int j) {
    String t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
    return arr;
  }

  List<String[]> res;

  void combine(String[] arr, int k) {
    if (k == arr.length) res.add(Arrays.copyOf(arr, arr.length));
    for (int i = k; i < arr.length; i++) {
      swap(arr, k, i);
      combine(arr, k + 1);
      swap(arr, k, i);
    }
  }
}
