package string;

/*
    medium*
   create shortest palindrome, from a given string

   abcdc

   abcdcba


*/
public class StringToPalidrome {

  String buildPalindrome(String st, int i, int j) {
    int n = st.length();
    while (i >= 0 && j < n && st.charAt(i) == st.charAt(j)) {
      i--;
      j++;
    };
    if (j != n) return null;
    while (i >= 0) st += st.charAt(i--);
    return st;
  }

  String buildPalindrome(String st) {
    for (int p = (st.length() - 1) / 2; p < st.length(); p++) {
      String s1 = buildPalindrome(st, p, p + 1);
      String s2 = buildPalindrome(st, p - 1, p + 1);
      if (s1 == null && s2 == null) continue;
      if (s1 != null && s2 != null) return s1.length() > s2.length() ? s2 : s1;
      return s1 == null ? s2 : s1;
    }
    return st;
  }

  public static void main(String[] args) {
    StringToPalidrome cp = new StringToPalidrome();
    System.out.println(cp.buildPalindrome("aa"));
    System.out.println(cp.buildPalindrome("abcdc"));
    System.out.println(cp.buildPalindrome("abb"));
    System.out.println(cp.buildPalindrome("abbb"));
    System.out.println(cp.buildPalindrome("aaa"));
  }
}
