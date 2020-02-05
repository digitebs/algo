package math;

import static java.lang.Integer.*;
import static java.lang.Math.abs;

public class ReverseInteger {
  static int reverse(int x) {
    long sign = x < 0 ? -1 : 1, y = (x = abs(x)) % 10; // keep it long so we dont overflow
    while ((x /= 10) != 0) y = y * 10 + x % 10;
    return ((y *= sign) > MAX_VALUE || y < MIN_VALUE) ? 0 : (int) y;
  }

  public static void main(String[] args) {
    System.out.println(reverse(-100));
  }
}
