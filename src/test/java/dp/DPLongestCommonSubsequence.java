package dp;

public class DPLongestCommonSubsequence {
    // longest common subsequence of 2 string
    static int common(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    memo[i][j] = memo[i-1][j-1]+1;
                else
                    memo[i][j] = Math.max(memo[i][j-1],memo[i-1][j]);
            }
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println(common("OUDFRMYMAW","AWHYFCCMQX"));
    }
}
