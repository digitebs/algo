package bit;

import java.util.stream.Collectors;

/*
   medium* but difficult to implement

   you have 2 combs in your possession, both of which are old and miss a tooth or more.
    She also has many purses of different length, in which she carries the combs.
     The only way they fit is horizontally and without overlapping.
      Given teeth' positions on both combs, find the minimum length of the purse she needs to take them with her.

   It is guaranteed that there is at least one tooth at each end of the comb.
   It is also guaranteed that the total length of two strings is smaller than 13.
   Note, that the combs can not be rotated/reversed.

   Input: comb1 = "*..*" and comb2 = "*.*", the output should be
   Output: 5.
*/
public class Combs {

  // bit count
  int log2(int n) {
    return (int) (Math.log(n) / Math.log(2) + 1);
  }

  /* represent as bits */
  int combs(String comb1, String comb2) {
    comb1 =
        comb1
            .chars()
            .mapToObj(
                x -> switch (x) {
                  case '.' -> '0';
                  case '*' -> '1';
                  default -> (char) x;
                })
            .map(String::valueOf)
            .collect(Collectors.joining());

    comb2 =
        comb2
            .chars()
            .mapToObj(
                x ->
                    switch (x) {
                      case '.' -> '0';
                      case '*' -> '1';
                      default -> (char) x;
                    }
            )
            .map(String::valueOf)
            .collect(Collectors.joining());

    int c1 = Integer.valueOf(comb1, 2);
    int c2 = Integer.valueOf(comb2, 2);
    int min = 13;
    for (int i = 0; i <= comb1.length(); i++) {
      int c3 = c2 << i; // pad
      if ((c1 & ~c3) == c1) {
        min = Math.min(min, Math.max(log2(c3), log2(c1)));
      }
    }
    for (int i = 0; i < comb2.length(); i++) {
      int c3 = c1 << i; // pad
      if ((c2 & ~c3) == c2) {
        min = Math.min(min, log2(c3));
      }
    }
    return min;
  }

  /* without bits requires compare per string */
  int combs2(String comb1, String comb2) {
    int m = comb2.length();
    int n = comb1.length();
    int k = 1, o = m + n;
    int min = o;
    out:
    while (k++ < o) {
      int s = Math.max(k - m, 0);
      int e = Math.min(k, n);
      for (int i = s; i < e; i++) {
        if (comb2.charAt(Math.max(m - k, 0) + (i - s)) == '*' && comb1.charAt(i) == '*') {
          continue out;
        }
      }
      min = Math.min(min, (k >= n) ? k : Math.max(o - k, n));
    }
    return min;
  }

  public static void main(String[] args) {
    Combs c = new Combs();
    System.out.println(c.combs2("*..*", "*.*"));
    System.out.println(c.combs2("*...*", "*.*"));
    System.out.println(c.combs2("**", "**"));
    // System.out.println(c.combs("*..*.*","*.***"));
  }
}
