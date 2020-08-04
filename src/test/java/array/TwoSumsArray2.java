package array;

import java.util.*;
import java.util.stream.IntStream;

/**
 *
 *
 * given an arrayy find all the 2 numbers that return the sum in that SAME array
 *
 *
 */
public class TwoSumsArray2 {
  static void twoSumPointers(int[] nums) {


    Arrays.sort(nums);
    for(int k = 0; k < nums.length; k++) {
      int i = 0, j = nums.length - 1;
      while (i < j) {
       // System.out.println(i+" "+j);
        if(i==k) i++;
        else if(j==k) j--;
        if (nums[i] + nums[j] == nums[k]){

            System.out.println(nums[i]+"+"+nums[j] +"="+ nums[k]);
          i++;
          j--;
        }
        else if (nums[i] + nums[j] > nums[k]) j--;
        else i++;
      }
    }
  }

  public static void main(String[] args) {
    // System.out.println(Arrays.toString(twoSumPointers(new int[]{0,2,5,6,8}, 11)));
    // System.out.println(countPairs(Arrays.asList(1, 3, 46, 1, 3, 9), 47));
    // System.out.println(twoSumDup(new int[]{2,2,2,2,2},4));

  twoSumPointers(new int[]{1,1,1,2,2,3});
    // System.out.println(Arrays.toString(new TwoSumsArray().twoSum(new int[]{2, 7, 11, 15}, 9)));
  }
}
