package sort;

import java.util.Arrays;

/**
 * @author john.lim
 *     <p>Given an array, sort the colors rgb(0,1,2) Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 *     <p>without using sorting library, green comes then blue then red
 */
public class SortColors {

  /*
     using in place constant space
  */
  public static void sortColors(int[] nums) {
    int i = 0, start = 0;
    int end = nums.length - 1;
    while (i <= end) {
      if (nums[i] == 0) {
        nums[i] = nums[start]; // swap to 1st
        nums[start] = 0;
        start++;
        i++;
      } else if (nums[i] == 2) {
        nums[i] = nums[end]; // swap to end
        nums[end] = 2;
        end--;
      } else i++;
    }
  }

  public static void main(String[] args) {
    int[] n = new int[] {2, 0, 2, 1, 1, 0};
    sortColors(n);
    System.out.println(Arrays.toString(n));
  }
}
