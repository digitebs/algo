package stack;

import model.Tuple;

import java.util.Stack;

/*

 Implement  a min stack, min stack has a get min method that returns the minimum element in the stack
*/
class MinStack {
  Stack<int[]> s = new Stack<>();

  /** initialize your data structure here. */
  public MinStack() {}

  public void push(int x) {
    s.push(new int[] {x, Math.min(x, !s.isEmpty() ? s.peek()[1] : x)});
  }

  public void pop() {
    s.pop();
  }

  public int top() {
    return s.peek()[0];
  }

  public int getMin() {
    return s.peek()[1];
  }
}
