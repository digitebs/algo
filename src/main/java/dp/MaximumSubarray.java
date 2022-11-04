package dp;

/**
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int max, sum;
    sum = max = nums[0];
    for (int i= 1; i < nums.length; i++){
      sum = Math.max(nums[i], sum + nums[i]);
      max = Math.max(sum, max);
    }

    return max;
  }
  public static void main(String[] args) {
    var ms  = new MaximumSubarray();
    System.out.println();

    assert ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) == 6;
    assert ms.maxSubArray(new int[]{5,4,-1,7,8}) == 23;
  }
}
