package math;

import java.util.HashSet;
import java.util.Set;

/*
A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits,
  and repeat the process until the number equals 1 (where it will stay),
   or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy numbers.

    Input: 19
    Output: true
 */
public class HappyNumber {

  // x^2 - y^2 == (x-y)(x+y) if - can factor out
  public int sumOfSquare(int n) {
    int sum = 0;
    do {
      int r = n % 10;
      sum += r * r;
    } while ((n /= 10) > 0);
    return sum;
  }

  public boolean isHappy2(int n) {

    // cycle only happens for this 8 values:
    Set<Integer> hs = new HashSet() {{
      add(1);
      add(4);
      add(16);
      add(37);
      add(58);
      add(145);
      add(42);
      add(20);
    }};

    while (!hs.contains(n = sumOfSquare(n))) ;
    return n == 1;
  }

  // you can use fast and slow pointer for cycle detection
  public boolean isHappy(int n) {

    Set<Integer> hs = new HashSet<>();
    hs.add(n);
    while (hs.add(n = sumOfSquare(n))) ;
    return hs.contains(1);
  }

  // no hash, 6 tries is a cycle????
  public boolean isHappy3(int n) {
    for (int i = 0; i < 6; i++) { // 6 loops is mostly a cycle
      int sum = 0;
      do {
        int r = n % 10;
        sum += r * r;
      } while ((n /= 10) > 0);
      if ((n = sum) == 1) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    HappyNumber hn = new HappyNumber();
    System.out.println(hn.isHappy(19));
  }
}
