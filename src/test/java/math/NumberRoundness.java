package math;

/*
Define an integer's roundness as the number of trailing(1100000) zeroes in it.

Given an integer n, check if it's possible to increase n's roundness by swapping some pair of its digits.


 */
public class NumberRoundness {
  boolean increaseNumberRoundness(int n) {
    boolean nonzero = false;
    do {
      int r = n % 10;
      if (nonzero && r == 0) return true;
      if (r != 0) nonzero = true;
    } while ((n /= 10) > 0);
    return false;
  }

  public static void main(String[] args) {
    NumberRoundness nr = new NumberRoundness();
    System.out.println(nr.increaseNumberRoundness(902200100));
  }
}
