package math;

/**
 * @author john.lim
 *     <p>you can find the gcd pf string by calculating the gcd of length of both string. and
 *     checking if all of the substring matches it
 *     <p>instaead of brute force reduing the numbers and trying if it can fit.
 *     <p>checking the length 1st whats the largets possible gcd. since its repetitive then its a
 *     factor
 */
public class GCDStrings {
  /*
      this approach find the potential match using gcd of length
      then do a negative case around this match
      by checking if all characters match

  */
  public String gcdOfStrings(String str1, String str2) {
    String longer = str1.length() > str2.length() ? str1 : str2;
    String shorter = str1.equals(longer) ? str2 : str1;
    int gcd = calculateGCD(longer.length(), shorter.length());

    int index = 0;
    String sgcd = shorter.substring(0, gcd); // is potential match
    while (index < longer.length()) {
      int cur = longer.indexOf(sgcd, index);
      if (cur != -1) {
        index = cur + gcd;
      } else {
        return "";
      }
    }
    return longer.length() % shorter.length() == 0 ? shorter : sgcd;
  }

  private int calculateGCD(int a, int b) {
    return b == 0 ? a : calculateGCD(b, a % b);
  }

  public static void main(String[] args) {
    System.out.println(new GCDStrings().gcdOfStrings("ABABAB", "ABAB"));
  }
}
