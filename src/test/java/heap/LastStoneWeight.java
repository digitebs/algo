package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*

medium*

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.
  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 */
public class LastStoneWeight {

  int max1 = 0, max2 = 0;

  public void findMax(int[] arr) {
    max2 = 0; // reset;
    max1 = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max1) {
        max2 = Math.max(max2, max1);
        max1 = arr[i];
      } else if (arr[i] > max2) {
        max2 = arr[i];
      }
    }
  }

  public int lastStoneWeight2(int[] stones) {

    int[] arr = new int[stones.length - 1];

    while (arr.length > 0) {
      findMax(stones);
      boolean max1found = false, max2found = false;
      int i = 0;
      for (int s : stones) {
        if (s == max1 && !max1found) {
          arr[i++] = max1 - max2;
          max1found = true;
        } else if (s == max2 && !max2found) {
          max2found = true;
        } else arr[i++] = s;
      }
      stones = arr;
      arr = new int[stones.length - 1];
    } ;
    return stones[0];
  }


  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for(int s: stones){
      pq.add(s);
    }
    while (pq.size() > 1) {
      // System.out.println(pq);
      pq.offer(pq.poll()-pq.poll()); // remove top 2;
    } ;
    return pq.poll();// get last
  }

  public static void main(String[] args) {
    LastStoneWeight lsw = new LastStoneWeight();
    System.out.println(lsw.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    System.out.println(lsw.lastStoneWeight(new int[]{1, 3}));
    System.out.println(lsw.lastStoneWeight(new int[]{2, 2}));
    System.out.println(lsw.lastStoneWeight(new int[]{4, 6, 4, 10}));
  }
}
