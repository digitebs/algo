package string;

import static java.lang.System.out;

public class OneEditAwayString {

  /**
   * Method use to check if there is only one possible edit given 2 string.
   *
   * <p>one edit means add or delete or edit one character to match 2 string as [[Equals]]
   *
   * <p>==Example== {{{ "apple" vs "apkole" is false "e" vs "le" is true }}}
   *
   * @return
   */
  public static boolean OneEditAway(char[] s1, char[] s2) {
    char[] b = s1, s = s2;
    if (s2.length > s1.length) {
      b = s2;
      s = s1;
    }
    if (b.length - s.length > 1) return false;

    for (int i = 0, j = 0; i < s.length; i++) {
      if (s.length == b.length) {
        if (b[i] != s[i]) j++;
        if (j > 1) return false;
      } else {
        if (b[i] == s[j]) j++; // increment once
        if (i - j > 1) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    /*out.println(OneEditAway("apple".toCharArray(),"apkole".toCharArray()));
    out.println(OneEditAway("kar".toCharArray(),"e".toCharArray()));
    out.println(OneEditAway("ar".toCharArray(),"e".toCharArray()));
    out.println(OneEditAway("e".toCharArray(),"ar".toCharArray()));
    out.println(OneEditAway("".toCharArray(),"eeee".toCharArray()));
    out.println(OneEditAway("abc".toCharArray(),"def".toCharArray()));

    out.println(OneEditAway("apple".toCharArray(),"apple".toCharArray()));
    out.println(OneEditAway("e".toCharArray(),"ek".toCharArray()));
    out.println(OneEditAway("e".toCharArray(),"le".toCharArray()));
    out.println(OneEditAway("a".toCharArray(),"a".toCharArray()));
    out.println(OneEditAway("".toCharArray(),"e".toCharArray()));
    out.println(OneEditAway("".toCharArray(),"".toCharArray()));*/

    out.println(OneEditAway("pale".toCharArray(), "ple".toCharArray()));
    out.println(OneEditAway("pales".toCharArray(), "pale".toCharArray()));
    out.println(OneEditAway("pale".toCharArray(), "bale".toCharArray()));
    out.println(OneEditAway("pale".toCharArray(), "bae".toCharArray()));
  }
}
