package math;

/*
Easy*

 A ticket is lucky if the sum of the first half of the digits is equal to the sum of the second half.

Given a ticket number of even digits n, determine if it's lucky or not.

1230 1+2 = 3+0
true

239017 2+3+9 != 0+1+7
false
 */

public class LuckyNumber {
  int count(int n) {
    int c = 0;
    do {
      c++;
    } while ((n /= 10) > 0);
    return c;
  }

  boolean isLucky(int n) {
    int a = 0, c = count(n) / 2;
    int i = 0;
    do {
      int r = n % 10;
      a += (i++ < c) ? r : -r;
    } while ((n /= 10) > 0);
    return (a == 0);
  }

  public static void main(String[] args) {
    //
    LuckyNumber ln = new LuckyNumber();
    System.out.println(ln.isLucky(1230));
    System.out.println(ln.isLucky(239017));
    System.out.println(ln.isLucky(100000));
  }
}
