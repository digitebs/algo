package map;

import java.util.HashMap;

// The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
public class MapMaxConsecutive {
  static int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int max = 0;
    for (int num : nums) {
      if (hm.containsKey(num)) continue;
      int left = hm.getOrDefault(num - 1, 0);
      int right = hm.getOrDefault(num + 1, 0);
      int sum = left + right + 1;
      hm.put(num, sum);
      hm.put(num - left, sum);
      hm.put(num + right, sum);
      max = Math.max(sum, max);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
  }
}
