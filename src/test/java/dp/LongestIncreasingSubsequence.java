package dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3] Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7] Output: 1
 */
public class LongestIncreasingSubsequence {

  int lengthOfLIS(int[] nums) {
    int max = 0;
    int n = nums.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && dp[i] <= dp[j]) {
          dp[i] = dp[j] + 1;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    System.out.println(lis.lengthOfLIS(new int[]{0,1,0,3,2,3}));
  }
}
