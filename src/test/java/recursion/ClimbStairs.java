package recursion;

/*

thsi is a variation of recursive fib.

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {
  public static int climbStairs(int n) {
    return fib(n, new int[n + 1]);
  }

  public static int fib(int n, int[] memo) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (memo[n] == 0) memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
    return memo[n];
  }

  public static void main(String[] args) {
    System.out.println(climbStairs(5));
  }
}
