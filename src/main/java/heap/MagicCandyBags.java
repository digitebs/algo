package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 You have N bags of candy. The ith bag contains arr[i] pieces of candy,
  and each of the bags is magical!

 It takes you 1 minute to eat all of the pieces of candy in a bag
 (irrespective of how many pieces of candy are inside),
  and as soon as you finish, the bag mysteriously refills. If there were x pieces of
  candy in the bag at the beginning of the minute,
   then after you've finished you'll find that floor(x/2) pieces are now inside.

 You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?


 N = 5
 k = 3
 arr = [2, 1, 7, 4, 2]
 output = 14

 Explanation:
 minute eaten  refill
 1      7/2      3
 2      4/2      2
 3      3/2      1

 7 + 4+ 3  = 14

*/
public class MagicCandyBags {
  int maxCandies(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int a : arr) {
      pq.offer(a);
    }
    int count = 0;
    while (k-- > 0) {
      count += pq.peek();
      pq.offer(pq.poll() / 2);
    }

    return count;
  }

  public static void main(String[] args) {
    MagicCandyBags mcb = new MagicCandyBags();
    System.out.println(mcb.maxCandies(new int[] {2, 1, 7, 4, 2}, 3));
  }
}
