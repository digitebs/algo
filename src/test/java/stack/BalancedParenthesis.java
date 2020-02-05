package stack;

import java.util.Stack;

public class BalancedParenthesis {
  static String isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '{' || c == '[' || c == '(') stack.push(c);
      else if (stack.isEmpty()) return "NO";
      else {
        char p = stack.pop();
        if (c == ')' && p != '(' || c == ']' && p != '[' || c == '}' && p != '{') return "NO";
      }
    }
    return stack.isEmpty() ? "YES" : "NO";
  }
}
