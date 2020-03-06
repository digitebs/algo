package stack;

import java.util.Stack;


/* do it without split and reverse */
public class ReverseStringSpace {

  static void reverse(String s) {

    Stack<Character> letter = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      letter.push(s.charAt(i));
    }

    Stack<StringBuilder> words = new Stack<>();
    StringBuilder sb = new StringBuilder();
    while (!letter.isEmpty()) {
      Character c = letter.pop();
      if (c == ' ') {
        words.push(sb);
        sb = new StringBuilder();
      } else sb.append(c);
    }

    words.push(sb);
    // System.out.print(words);
    while (!words.isEmpty()) {
      System.out.print(words.pop() + " ");
    }
  }
  // emosewa si netukar
  public static void main(String[] args) {
    reverse("rakuten is awesome");
  }
}
