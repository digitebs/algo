package string;

public class Password {
  public int solutionPassowrd(String S) {
    // write your code in Java SE 8

    String[] str = S.split("\\d+");

    int length = 0;
    for (int i = 0; i < str.length; i++) {
      for (int j = 0; j < str[i].length(); j++) {
        if (Character.isUpperCase(str[i].charAt(j))) {
          // System.out.println(str[i].length());
          length = Math.max(length, str[i].length());
          break;
        }
      }
    }
    if (length == 0) return -1;
    return length;
  }

  public static void main(String[] args) {
    System.out.println(new Password().solutionPassowrd("AA3ABA"));
  }
}
