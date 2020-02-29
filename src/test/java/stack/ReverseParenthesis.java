package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/*

medium*

  Write a function that reverses characters in parentheses in the input string.
  "ra(kut)en"
  "ratuken"

  "(ra(kut)en)"
  "nekutar"
 */
public class ReverseParenthesis {
  public static void main(String[] args) {
    reverse("ad(oi(love)ew)jkl(bnm)");
    reverse("(ra(kut)en)");
  }

  public static void reverse(String s) {
    Stack<Character> stack = new Stack<>();
    Queue<Character> q = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      // n * S) where S is the numeber parenthsies n == character
      char c = s.charAt(i);
      if (c == ')') {
        char p;
        while ( (p = stack.pop()) !='(') {
          q.offer(p);
        }
        while(!q.isEmpty()){
          stack.push(q.poll());
        }
      } else {
        stack.push(c);
      }
    }
    System.out.println(stack.stream().map(Object::toString).collect(Collectors.joining()));
  }
}
