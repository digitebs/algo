package array;

import java.util.Arrays;
import java.util.HashMap;

/*
   4 sum return 1st duplicate
*/
public class FourSumArray {
  static int[] findArrayQuadruplet(int[] arr, int s) {
    // your code goes here
    Arrays.sort(arr); // 2sum
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      hm.put(s - arr[i], i); // put lats
    }
    for (int w = 0; w < arr.length; w++) { // n
      int x = w + 1;
      int z = arr.length - 1;
      while (x < z) { // n
        int sum = arr[w] + arr[x] + arr[z];
        if (hm.containsKey(sum)) {
          int y = hm.get(sum);
          if (w != y && x != y && z != y) {
            return new int[] {
              arr[w], arr[x],
              arr[y], arr[z]
            };
          }
        }
        if (sum >= s || arr[z - 1] == arr[z]) {
          z--;
        } else {
          x++;
        }
      }
    }
    return new int[] {};
  }

  /*
  Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

  0 <= i, j, k, l < n
  nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
   */

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    var count=0;
    var hm = new HashMap<Integer,Integer>();
    for (var x: nums1)
      for (var y: nums2)
        hm.compute(x+y,(k,v)-> v==null?1:v+1);

    // System.out.println(hm);
    for (var x: nums3)
      for (var y: nums4)
        count+= hm.getOrDefault(-(x+y),0);



    return count;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(findArrayQuadruplet(new int[] {2, 7, 4, 0, 9, 5, 1, 3}, 20)));
  }
}
