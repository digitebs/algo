package heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * STDIN               Function
 * -----               --------
 * 6 7                 A[] size n = 6, k = 7
 * 1 2 3 9 10 12       A = [1, 2, 3, 9, 10, 12]
 *
 * Sample Output
 *
 * 2
 *
 * Explanation
 *
 * Combine the first two cookies to create a cookie with sweetness  = 1 x 1 + 2 x 2 = 5
 * After this operation, the cookies are 3,5,9,10,12.
 * Then, combine the cookies with sweetness 3 and sweetness 5, to create a cookie with resulting sweetness  = 1 x 3 + 2 x 5 = 13
 * Now, the cookies are 9,10,12,13.
 * All the cookies have a sweetness >= 7.
 *
 * Thus,  operations are required to increase the sweetness.
 */
public class JesseCookies {

  public static int cookies(int k, List<Integer> arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (Integer a : arr) {
      pq.offer(a);
    }

    int op = 0;
    while (pq.size() > 1 && pq.peek() < k ) {
      pq.offer(pq.poll() + pq.poll() * 2);
      op++;
    }

    if (pq.peek() < k) return -1;

    return op;
  }

  public static void main(String[] args) {
    System.out.println(JesseCookies.cookies(9, Arrays.asList(2,7,3,6,4,6)));
  }

}
