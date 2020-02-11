package math;

import java.util.HashMap;

/** find if a number is power of i,j */
public class Power {

  HashMap<Integer, Double> hm = new HashMap<>();
  /*
     find the nth power of x
     using recursion and memo
  */
  public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n == -1) return 1 / x;
    if (n == 1) return x;
    if (!hm.containsKey(n)) {
      hm.put(n, myPow(x, n / 2) * myPow(x, n / 2 + (n % 2 == 0 ? 0 : (n < 0 ? -1 : 1))));
    }
    return hm.get(n);
  }

  static boolean isPower(int a) {
    if (a == 1) return true;
    for (int i = 2; i < a; i++) {
      int j = 2;
      double pow;
      do {
        pow = Math.pow(i, j);
        if (pow == a) return true;
        j++;
      } while (pow < a);
    }
    return false;
  }

  /*
       4^y = n
       log4(n) = y
       log10(n)/log10(3) formula for base change
       %1 to check if its a whole number
   */
  public static boolean isPowerOfThree(int n) {
    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    //  return n > 0 && 1162261467 % n == 0;
  }

  public static void main(String[] args) {
    System.out.println(isPower(9));
    System.out.println(isPowerOfThree(7));
    System.out.println((Math.log10(7) / Math.log10(3)));
  }
}
