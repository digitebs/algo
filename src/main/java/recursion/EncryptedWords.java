package recursion;

/*
    encrypt the given string.

    For example, to encrypt the string "abc",
    we first take "b", and then append the encrypted version of "a" (which is just "a")
    and the encrypted version of "c" (which is just "c") to get "bac".

    If we encrypt "abcxcba" we'll get "xbacbca".
    That is, we take "x" and then append the encrypted version "abc"
    and then append the encrypted version of "cba".

    Example 1
    S = "abc"
    R = "bac"
    Example 2
    S = "abcd"
    R = "bacd"
    Example 3
    S = "abcxcba"
    R = "xbacbca"
    Example 4
    S = "facebook"
    R = "eafcobok"

    easy*

 */
class EncryptedWords {

  String findEncryptedWord(String s) {
    // min string is 1
    // if(s.length() == 0) return "";
    if (s.length() <= 1) return s;

    int mid = (s.length() - 1) / 2; // roudn down

    return s.charAt(mid)
        + findEncryptedWord(s.substring(0, mid))
        + findEncryptedWord(s.substring(mid + 1));
  }

  public static void main(String[] args) {

    EncryptedWords ew = new EncryptedWords();
    System.out.println(ew.findEncryptedWord("abc"));
    System.out.println(ew.findEncryptedWord("abcd"));
    System.out.println(ew.findEncryptedWord("abcxcba"));
    System.out.println(ew.findEncryptedWord("facebook"));
  }
}
