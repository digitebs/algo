package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;



/*

  Given an array of integers a. There is a sliding window of size k which
  is moving from the very left of the array to the very right.
  You can only see the k numbers in the window. Each time the sliding window moves
  rightwards by one position. You have to find the maximum for each window.
  The following example will give you more clarity.

  Input:
      a = [1, 3, -1, -3, 5, 3, 6, 7]
      k = 3
  Output:
      [3, 3, 5, 5, 6, 7]


  Explanation:
  [1 3 -1] -3 5 3 6 7	3
  1 [3 -1 -3] 5 3 6 7	3
  1 3 [-1 -3 5] 3 6 7	5
  1 3 -1 [-3 5 3] 6 7	5
  1 3 -1 -3 [5 3 6] 7	6
  1 3 -1 -3 5 [3 6 7]	7


 */
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
    System.out.println(slidingMax(new ArrayList<>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7)), 3));
  }
}
