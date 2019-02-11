package dp;

import static java.lang.Math.max;

public class DPMaxSubsetSum {

    // 2 1 3 4 5
    // 2 2 5

    // 1 2 3 4 5
    // 1 2 3 4 5

    // 1 2 4 4 5
    // 1 2 4 6 5
    // 1 2 4 6 9 // the max is stored besides
    static int maxSubsetSum(int[] arr) {
        int[] memo = new int[arr.length];
        memo[1]=max(memo[0]=arr[0],arr[1]);
        for(int i = 2;i < arr.length; i++)
            memo[i]=max(max(memo[i-2]+ arr[i], arr[i]),memo[i-1]);
        return memo[arr.length-1];
    }
    public static void main(String[] args) {
        System.out.print(maxSubsetSum(new int[]{1,2,3,4,5}));
    }
}
