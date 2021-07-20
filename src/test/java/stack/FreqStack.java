package stack;

import model.Triple;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.

Use priorityqueue
 */
class FreqStack {
  int count = 0;
  PriorityQueue<Triple> pq =
      new PriorityQueue<>((a, b) -> (b._1 == a._1 ? b._3 - a._3 : b._1 - a._1));
  HashMap<Integer, Integer> hm = new HashMap<>();

  public void push(int x) {

    hm.put(x, hm.getOrDefault(x, 0) + 1);
    pq.add(new Triple(hm.get(x), x, count++)); // resorts it
  }

  public int pop() {
    Triple t = pq.remove();
    hm.put(t._2, hm.get(t._2) - 1);
    return t._2;
  }
}
