package stack;


import java.util.Stack;

/**
 * Given a balanced parentheses string s, return the score of the string.
 *
 * The score of a balanced parentheses string is based on the following rule:
 *
 * "()" has score 1.
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: 1
 * Example 2:
 *
 * Input: s = "(())"
 * Output: 2
 * Example 3:
 *
 * Input: s = "()()"
 * Output: 2
 *
 */
public class ScoreOfParentheses {
  public int scoreOfParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for(int i=0; i< s.length();i++){
      if(s.charAt(i) == ')'){
        stack.push(Math.max(stack.pop() * 2, 1) + stack.pop());
      }else{
        stack.push(0);
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    ScoreOfParentheses sop = new ScoreOfParentheses();
    System.out.println(sop.scoreOfParentheses("(())"));
  }
}
