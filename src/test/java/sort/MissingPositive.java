package sort;

import java.util.Arrays;

public class MissingPositive {
  public int firstMissingPositive(int[] nums) {
    Arrays.sort(nums);
    /*int min = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= 1) {
        if (i != 0 && nums[i] == nums[i - 1]) ;
        else if (min == nums[i]) min++;
        else break;
      }
    }*/
    for (int i = 0; i < nums.length; i++) {
      if (i != nums[i]-1) return i+1; // exclude 0
    }
    return nums.length;
  }

  /** the missing positive should be within the array, no duplicate allowed */
  public int firstMissingPositiveDistinct(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];
      // 3 1, 2, 0
      if (temp != i && temp < nums.length) {
        nums[i] = nums[i] ^ nums[temp];
        nums[temp] = nums[i] ^ nums[temp];
        nums[i] = nums[i] ^ nums[temp];
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
    System.out.println(mp.firstMissingPositive(new int[] {2, 3, 3, 6}));
    System.out.println(mp.firstMissingPositive(new int[] {1, 1, 2}));
    System.out.println(mp.firstMissingPositive(new int[] {-1, -3, -3, 2, 6}));
    System.out.println(mp.firstMissingPositive(new int[] {-1, -3}));
    System.out.println(mp.firstMissingPositive(new int[] {6}));
    System.out.println(mp.firstMissingPositiveDistinct(new int[] {600, 100, 60, 5}));
  }
}
