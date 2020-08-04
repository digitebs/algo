package stack;

import java.util.Stack;


/*

Given 2 strings, return if they are equal when both are typed into empty text editors.
 # means a backspace character.


Input: "ab##", "c#d#"
Ouput: True

Input: "eab##", "c#d#e"
Ouput: True

Input: a#c, b
Output: False


 */
public class BackSpaceCompare {

  public Stack<Character> removeBackSpace(String s){
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '#') {
        if (stack.isEmpty()) continue;
        stack.pop();
      } else if (c != '#') {
        stack.push(c);
      }
    }
    return  stack;
  }
  public boolean backspaceCompare(String S, String T) {

    Stack s1 = removeBackSpace(S);
    Stack s2 = removeBackSpace(T);
    while(!s1.isEmpty() && !s2.isEmpty()){
      if(s1.pop() != s2.pop())
        return false;
    }
    return  s1.isEmpty() && s2.isEmpty();
  }

  public static void main(String[] args) {
    BackSpaceCompare bsc = new BackSpaceCompare();
    System.out.println(bsc.backspaceCompare("a##c","#a#c"));
    System.out.println(bsc.backspaceCompare("a#c","b"));
    System.out.println(bsc.backspaceCompare("ab##", "c#d#"));
  }
}
