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
    return isPower(n, 3);
    //  return n > 0 && 1162261467 % n == 0;
  }

  public static boolean isPowerOfFive(int n) {
    return isPower(n, 5);
    //  return n > 0 && 1162261467 % n == 0;
  }

  public static boolean isPower(int n, int k) {
    // System.out.println(Math.pow(n, 1./3));
    float x = (float)(Math.log(n) / Math.log(k));
    // System.out.println(x);
    return x%1 == 0; // some precision on 125, 5 tsktsk!!!
  }

  static int depositProfit(int deposit, int rate, int threshold) {
    // t  = p * (1 + r)^y
    // solve for y
    // using base conversion
    return ceil(Math.log10((double) threshold / deposit) / Math.log10(1 + rate / 100.));
    // return (int) ((Math.log10((double) threshold / deposit)-1) / Math.log10(1 + rate / 100.)) +
    // 1;
  }

  // how to ceil using cast
  static int ceil(double num) {
    return (int) num + (num == (int) num ? 0 : 1);
  }

  public static void main(String[] args) {
    // System.out.println(isPower(9));
    System.out.println(isPowerOfFive(125));
    System.out.println(isPower(72,1));
    // System.out.println(isPowerOfThree(243));
    // System.out.println(depositProfit(100,20,170));
  }
}
