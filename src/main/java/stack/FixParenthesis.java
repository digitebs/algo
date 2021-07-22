package stack;

/** how many count needed to fix the parenthesis */
public class FixParenthesis {
  static int bracketMatch(String text) {
    // your code goes here
    int count = 0;
    int fix = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == '(') count++;
      else count--;
      if (count < 0) {
        fix++;
        count = 0;
      }
    }
    return fix + count; // remaining open
  }

  public static void main(String[] args) {
    System.out.println(bracketMatch("())("));
  }
}
