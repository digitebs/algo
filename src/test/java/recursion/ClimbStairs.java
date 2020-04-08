package recursion;

/*

thsi is a variation of recursive fib.

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


 There are n people in a room. in how many ways can you infect all the people in the room.
  Assuming a person can only infect a number of people at min 1 and max 2.

  your initially not included in the room.

 */
public class ClimbStairs {
  public static int climbStairs(int n,int k) {
    return fib(n,k+1, new int[n + 1]);
  }

  public static int fib(int n,int k, int[] memo) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (memo[n] == 0){
      for(int i =1; i < k; i++) // k is max
      memo[n] += fib(n - i,k, memo);// fib(n - 2, memo);
    }
    return memo[n];
  }

  public static void main(String[] args) {
    System.out.println(climbStairs(4,2));
    // System.out.println(climbStairs(5));
  }
}
