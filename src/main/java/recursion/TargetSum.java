package recursion;

import java.util.Arrays;


/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 */
public class TargetSum {
  int total;
  public int findTargetSumWays(int[] nums, int target) {
    total = Arrays.stream(nums).sum();

    int[][] dp = new int[nums.length][2 * total +1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return ways(nums, target,0,0, dp);
  }

  public int ways(int[] nums , int target, int i, int sum,  int[][] dp){
    if(i== nums.length){
      return sum == target ? 1 :0;
    }

    int j = total + sum;
    if(dp[i][j] !=  -1){
      return dp[i][j] ;
    }

    return dp[i][j] = ways(nums,target,i+1,sum+nums[i],dp) + ways(nums,target,i+1,sum-nums[i],dp);
  }

  public static void main(String[] args) {
    var ts = new TargetSum();
    System.out.println(ts.findTargetSumWays(new int[]{1,1,1,1,1},3));
  }
}
