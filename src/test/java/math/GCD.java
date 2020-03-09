package math;

public class GCD {

  // 10, 15
  // 10, 10
  // 0, 10
  // 0 , 5

  // arithmetic progression = n(a1+an)/2
  // combination = n!/r!(n-r)!, permutation = n!/(n-r)!
  // mod allows your tp flip who is greater in denominator
  static int gcd(int a, int b) {
    return (b == 0) ? a :gcd(b, a % b);
  }

  //
  static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

  public static int generalizedGCD(int num, int[] arr) {
    // WRITE YOUR CODE HERE
    int a = arr[0];
    for (int i = 1; i < arr.length; i++) {
      a = gcd(a, arr[i]);
    }
    return a;
  }

  public static void main(String[] args) {
    System.out.println(generalizedGCD(5, new int[] {2, 4, 6, 8, 10}));
  }
}
