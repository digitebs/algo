package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/*
  given an array arr return an array res where the ith value is the largest 3 product for the
   given ith in arr

   n = 5
  arr = [1, 2, 3, 4, 5]
  output = [-1, -1, 6, 24, 60]
  The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.
 */
public class ThreeLargestProduct {
  int[] findMaxProduct(int[] arr) {
    // Write your code here
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    int n = arr.length;
    int[] res = new int[n];
    for(int i = 0; i < n; i++){
      pq.offer(arr[i]);
      if(pq.size() < 3) res[i] =-1;
      else{
        int a = pq.poll();
        int b = pq.poll();
        res[i] = a*b*pq.peek();;
        pq.offer(a);
        pq.offer(b);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    //

    ThreeLargestProduct tlp = new ThreeLargestProduct();
    int[] r = tlp.findMaxProduct(new int[]{1,2,3,4,5});
    int[] r1 = tlp.findMaxProduct(new int[]{2,1,2,1,2});

    System.out.println(Arrays.toString(r));
    System.out.println(Arrays.toString(r1));
  }
}
