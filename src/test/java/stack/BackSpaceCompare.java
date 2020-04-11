package stack;

import java.util.Stack;


/*

Given two strings S and T, return if they are equal when both are typed into empty text editors.
 # means a backspace character.


  Input: S = "ab##", T = "c#d#"
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
  }
}
