package recursion;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 */
public class UniquePath {
    static int[][] memo;
    static int paths(int x, int y, int m, int n){
        //  System.out.println(x+" "+y);
        if(x >= m || y >= n) return 0;

        if( x== m -1 && y == n-1)
            return 1; // concat

        if(memo[x][y] == 0)
            memo[x][y]=paths(x+1, y, m, n) + paths(x, y+1, m, n);
        return memo[x][y];
    }

    static int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return paths(0,0,m,n);
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
