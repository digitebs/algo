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

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(findArrayQuadruplet(new int[] {2, 7, 4, 0, 9, 5, 1, 3}, 20)));
  }
}
