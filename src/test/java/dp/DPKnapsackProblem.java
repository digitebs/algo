package dp;

public class DPKnapsackProblem {
    //           0 1 2 3 4 5 6 7
    // -------------------------
    // (1) 1    |0 1 1 1 1 1 1 1
    // (4) 3    |0 1 1 4 5 5 5 5
    // (5) 4    |0 1 1 4 5 6 6 9
    // (7) 5    |0 1 1 4 5 7 8 9
    static int knapsack(int wt[], int[] val, int t){
        int m = val.length;
        int[][] memo = new int[m+1][t+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= t; j++) {
                 if(j < wt[i-1])
                    memo[i][j] = memo[i-1][j];
                else
                    memo[i][j] = Math.max(val[i-1]+memo[i-1][j-wt[i-1]],memo[i-1][j]);
            }
        }
        return memo[m][t];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1,3,4,5},new int[]{1,4,5,7}, 7));
    }

}
