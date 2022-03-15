package stack;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 */
public class MinimumRemoveToMakeValidParentheses {

  public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    char[] ch = s.toCharArray();
    for (int i = 0; i < ch.length; i++) {
      char c = ch[i];
      if (c == ')') {
        if (stack.isEmpty()) {
          ch[i] = '.';
        } else stack.pop();
      } else if (c == '(') stack.push(i);
    }

    while (!stack.isEmpty()) ch[stack.pop()] = '.';

    for (char c : ch) if (c != '.') sb.append(c);

    return sb.toString();
  }

  public String minRemoveToMakeValid2(String s) {
    int count =0;
    StringBuilder sb = new StringBuilder();
    char[] ch = s.toCharArray();
    for(int i = 0; i < ch.length; i++){
      char c = ch[i];
      if(c ==')'){
        if(count!=0){
          //sb.append(c);
          count--;
        }else{
          ch[i] ='.';
        }
      }else{
        if(c=='(') count++;
      }

    }

    count =0;
    for(int i =ch.length-1; i >=0;i--){
      char c = ch[i];
      if(c =='('){
        if(count!=0){
          //sb.append(c);
          count--;
        }else{
          ch[i] ='.';
        }
      }else{
        if(c==')') count++;
      }
    }

    for (char c : ch) if (c != '.') sb.append(c);
    return sb.toString();
  }


  public static void main(String[] args) {

  }
}
