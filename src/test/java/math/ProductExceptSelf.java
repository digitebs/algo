package math;

import java.util.Arrays;

public class ProductExceptSelf {
    static int[] productExceptSelf(int[] num) {
        // 1 2 3 4
        // (2 * 3 * 4)
        // (1) * (3 * 4)
        // (1 * 2) * (4)
        // (1 * 2 * 3)
        int[] dp = new int[num.length];
        dp[0] = 1;
        for (int i = 1, tmp = 1; i < num.length; i++) dp[i] = tmp *= num[i - 1];
        for (int i = num.length - 2, tmp = 1; i >= 0; i--) dp[i] *= tmp *= num[i + 1];
        return dp;
    }

    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[]{1, 2, 3, 4});

        System.out.println(Arrays.toString(res));
    }
}
