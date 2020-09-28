package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/*

You're also given an integer x, and must perform x iterations of the following 3-step process:
Pop x elements from the front of queue (or, if it contains fewer than x elements, pop all of them)

Of the elements that were popped, find the one with the largest value
 (if there are multiple such elements, take the one which had been popped the earliest),
  and remove it

For each one of the remaining elements that were popped (in the order they had been popped),
 decrement its value by 1 if it's positive (otherwise, if its value is 0, then it's left unchanged),
  and then push it back onto the queue


Compute a list of x integers output, the ith of which is the 1-based index
 in the original array of the element which had been removed in step 2 during the ith iteration

  n = 6
  arr = [1, 2, 2, 3, 4, 5]
  x = 5
  output = [5, 6, 4, 1, 2]
 */
public class QueueRemovals {
  int[] findPositions(int[] arr, int x) {
    // Write your code here

    int n = arr.length;
    Queue<int[]> q = new LinkedList<>();
    Queue<int[]> q1 = new LinkedList<>();

    IntStream.range(0, n).forEach(i -> q.offer(new int[] {arr[i], i}));

    int[] res = new int[x];
    for (int i = 0; i < x; i++) {

      q1.clear();

      for (int j = 0; j < x && !q.isEmpty(); j++) {
        q1.offer(q.poll());
      }

      int[] max = q1.stream().max((a, b) -> a[0] - b[0]).get();
      q1.remove(max); // remove once;

      q1.forEach(
          p -> {
            p[0] = Math.max(p[0] - 1, 0);
            q.offer(p);
          });

      // q.stream().forEach(y -> System.out.print(y[0] + "," + y[1] + " ->"));
      // System.out.println("(" + max[0] + "," + max[1] + ")");

      res[i] = max[1] + 1;
    }

    return res;
  }

  public static void main(String[] args) {
    QueueRemovals q = new QueueRemovals();
    System.out.println(Arrays.toString(q.findPositions(new int[] {1, 2, 2, 3, 4, 5}, 5)));
  }
}
