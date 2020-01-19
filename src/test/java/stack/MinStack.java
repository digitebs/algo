package stack;

import model.Tuple;

import java.util.Stack;

/**
 * min stack
 */
class MinStack {
    Stack<Tuple> s = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }
    public void push(int x) {
        int temp = !s.isEmpty() ? s.peek()._2 : x;
        s.push(new Tuple(x, Math.min(x, temp)));
    }

    public void pop() {
        s.pop();

    }

    public int top() {
        return s.peek()._1;
    }

    public int getMin() {
        return s.peek()._2;
    }
}