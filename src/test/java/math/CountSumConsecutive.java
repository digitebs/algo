package math;

/**
 * Find the number of ways to express n as sum of some (at least two) consecutive positive integers.
 *
 * <p>For n = 9, output is 2.
 *
 * <p>n = 9: 2 + 3 + 4 = 9 and 4 + 5 = 9.
 *
 * <p>n = 8, output is 0.
 *
 * @author john.lim
 */
public class CountSumConsecutive {
  /*
     using sliding window two pointer
  */
  int isSumOfConsecutive2(int n) {

    int count = 0;
    int ans = 0;
    int i = 1, j = 1;
    while (i < n) {
      if (ans == n) {
        count++;
        ans += ++i;
        ans -= ++j;
      } else if (ans < n) {
        ans += i++;
      } else {
        ans -= j++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    CountSumConsecutive css = new CountSumConsecutive();
    System.out.println(css.isSumOfConsecutive2(9));
    System.out.println(css.isSumOfConsecutive2(8));
  }
}
