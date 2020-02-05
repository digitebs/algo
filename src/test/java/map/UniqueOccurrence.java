package map;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of integers arr, write a function that returns true if and only if the number of
 * occurrences of each val in the array is unique.
 *
 * <p>Input: arr = [1,2,2,1,1,3] Output: true Explanation: The val 1 has 3 occurrences, 2 has 2 and
 * 3 has 1. No two values have the same number of occurrences.
 */
public class UniqueOccurrence {
  public static boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }
    return hm.size() == (new HashSet<>(hm.values())).size();
  }

  public static void main(String[] args) {
    System.out.println(uniqueOccurrences(new int[] {1, 2, 2, 1, 1, 3}));
  }
}
