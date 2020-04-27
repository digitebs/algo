package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous
 * subarrays whose sum equals to k.
 *
 * <p>Example 1:
 *
 * <p>Input:nums = [1,1,1], k = 2 Output: 2
 *
 *  medium*. cumulative sum
 *
 * @author john.lim
 */
public class ConsecutiveTarget {

    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

  public static void main(String[] args) {
    //

      ConsecutiveTarget ct = new ConsecutiveTarget();
      //System.out.println(ct.subarraySum(new int[]{1,2,3},3));
      //System.out.println(ct.subarraySum(new int[]{1,2,1,2,1},3));
     // System.out.println(ct.subarraySum(new int[]{-1,-1,1},1));
     // System.out.println(ct.subarraySum(new int[]{0,0,2},2));
      System.out.println(ct.subarraySum(new int[]{1,1,1},2));
  }
}
