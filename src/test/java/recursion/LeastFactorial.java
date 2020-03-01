package recursion;

/*
    easy
 */
public class LeastFactorial {
    int leastFactorial(int n) {
        int res = 0;
        for(int i = 1;(res = factorial(i)) < n;i++);
        return res;
    }

    /* 1 ≤ n ≤ 120 */
    int factorial( int n ){
        if(n == 0) return 1;
        return n * factorial(n-1);
    }

  public static void main(String[] args) {
        LeastFactorial lf = new LeastFactorial();
    System.out.println(lf.leastFactorial(24));
  }
}
