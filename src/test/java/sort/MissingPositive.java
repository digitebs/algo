package sort;

import java.util.Arrays;

import static java.lang.System.out;

public class MissingPositive {
  public int firstMissingPositive(int[] nums) {
    Arrays.sort(nums);
    int min = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 1) {
        if (i != 0 && nums[i] == nums[i - 1]) ;
        else if (min == nums[i]) min++;
        else break;
      }
    }
    return min;
  }

  /** the missing positive should be within the array, no duplicate allowed */
  public int firstMissingPositiveDistinct(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];
      // 3 1, 2, 0
      if (temp > 0 && temp != i && temp < nums.length) {
        int t2 = nums[temp];
        nums[temp] = nums[i];
        nums[i] = t2;
        i--; // backtrack
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (i != nums[i]) return i;
    }
    return nums.length;
  }

  public static void main(String[] args) {
    MissingPositive mp = new MissingPositive();
    out.println(mp.firstMissingPositive(new int[] {2, 3, 3, 6}));
    out.println(mp.firstMissingPositive(new int[] {1, 1, 2}));
    out.println(mp.firstMissingPositive(new int[] {-1, -3, -3, 2, 6}));
    out.println(mp.firstMissingPositive(new int[] {-1, -3}));
    out.println(mp.firstMissingPositive(new int[] {6}));
    out.println(mp.firstMissingPositiveDistinct(new int[] {600, 100, 60, 5}));
  }
}
