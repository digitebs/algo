package dp;

/** maximize robbing the house but cant be adjacent in array */
public class RobHouse {
  /** using dp solution */
  public static int rob(int[] nums) {
    int n = nums.length;
    int[] memo = new int[n];

    if (n == 0) return 0;
    if (n == 1) return nums[0];
    if (n == 2) return Math.max(nums[0], nums[1]);

    memo[0] = nums[0];
    memo[1] = nums[1];
    memo[2] = nums[2] + nums[0];
    for (int i = 3; i < nums.length; i++) {
      memo[i] = nums[i] + Math.max(memo[i - 2], memo[i - 3]);
    }
    return Math.max(memo[n - 1], memo[n - 2]);
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[] {1, 2, 3, 1}));
  }
}
