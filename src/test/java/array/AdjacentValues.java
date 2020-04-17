package array;

// you can also use imports, for example:

import java.util.*;

/**
  Given an unsorted array, find the maximum difference between the successive elements in its
  sorted form.

   Input: [3,6,9,1]
   Output: 3
   Explanation: The sorted form of the array is [1,3,6,9], either
   (3,6) or (6,9) has the maximum difference 3.
 */
public class AdjacentValues {
  public int solution(int[] nums) {
    // write your code in Java SE 8
    if (nums == null || nums.length < 2){
      return 0;
    }
    Arrays.sort(nums);
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++){
      max = Math.max(max, nums[i] - nums[i-1]);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(new AdjacentValues().solution(new int[] {2, 6, 9, 3}));
  }
}
