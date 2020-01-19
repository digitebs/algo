package recursion;

public class Fibonacci {
    static int fib(int n, int[] memo){
        // 0 1 1 2
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(memo[n] == 0) memo[n] = fib(n - 2,memo) + fib(n -1,memo);
        return memo[n];
    }

    // 4
    // 1+ 2 + 3 + 5 == fib
    // 2^n this is exponential to O(n) with memoization
    public static void main(String[] args) {
         System.out.println(fib(3,new int[4]));
    }
}
