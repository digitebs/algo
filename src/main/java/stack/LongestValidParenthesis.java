package stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid
 * (well-formed) parentheses substring.
 *
 * Input: s = ")()())"
 * Output: 4
 */
public class LongestValidParenthesis {
  int isBalance(String s) {
    Stack<Integer> stack = new Stack<>();

    var max =0;
    var temp = -1;
    //fmt.Println(s)
    for (int j=0; j < s.length();j++){
      char c = s.charAt(j);
      if(c =='('){
        stack.push(j);
      }else if(c ==')' && stack.isEmpty()){
        temp = j;
      }else{
        stack.pop();
        var i = temp;
        if(!stack.isEmpty()){
          i = stack.peek();
        }
        max = Math.max(max, j- i);
      }
    }

    return max;
  }
  public static void main(String[] args) {
    LongestValidParenthesis lvp = new LongestValidParenthesis();
    System.out.println(lvp.isBalance(")()()("));

  }
}
