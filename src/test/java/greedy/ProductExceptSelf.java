package greedy;

import java.util.Arrays;

public class ProductExceptSelf {
  /*
     No divide
  */
  static int[] productExceptSelf(int[] nums) {
    // 1 2 3 4
    // (2 * 3 * 4)
    // (1) * (3 * 4)
    // (1 * 2) * (4)
    // (1 * 2 * 3)
    int n = nums.length;
    int[] dp = new int[n];
    if(n <= 1) return new int[]{};
    for (int i = 0, product = 1; i < n; i++) {
      dp[i] = product;
      product *= nums[i]; // 1, 1*2, 1*2,*3 1st half
    }
    for (int i = n - 1, product = 1; i >= 0; i--){
      dp[i] *= product;
      product *= nums[i]; // 4, 4*3, 4*3*2 lower half
    }
    return dp;
  }

  public static void main(String[] args) {
    int[] res = productExceptSelf(new int[] {1, 2, 3, 4});

    System.out.println(Arrays.toString(res));
  }
}
