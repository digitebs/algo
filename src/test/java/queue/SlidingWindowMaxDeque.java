package queue;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaxDeque {

  // O(n) solution
  static ArrayList<Integer> slidingMax(ArrayList<Integer> a, int k) {
    ArrayList<Integer> res = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<>();

    int i;
    for (i = 0; i < k; ++i) {
      while (!dq.isEmpty() && a.get(i) >= a.get(dq.peekLast()))
        dq.removeLast(); // keep removing the last
      dq.addLast(i);
    }
    for (; i < a.size(); ++i) {
      res.add(a.get(dq.peek()));
      while (!dq.isEmpty() && i - k >= dq.peek()) dq.removeFirst();
      while (!dq.isEmpty() && a.get(i) >= a.get(dq.peekLast()))
        dq.removeLast(); // keep removing the last
      dq.addLast(i);
    }
    res.add(a.get(dq.peek()));
    return res;
  }

  public static void main(String[] args) {
    System.out.println(slidingMax(new ArrayList<>(Arrays.asList(1, 2, 3, 1, 4, 5, 2, 3, 6)), 3));
  }
}
