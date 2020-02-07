package string;

import static java.lang.System.out;

/**
 * use to print the series of look and say given n
 *
 * @author johnlim
 */
public class CountAndSay {
  // 2 iterator slow and fast
  static String evaluate(String s) {
    StringBuilder say = new StringBuilder();
    char arr[] = s.toCharArray();
    int i = 0;
    // O(n) space and time complexity
    while (i < arr.length) {
      char c = arr[i]; // owkay this my character
      int k = i; // k is like the fast mover
      while (arr.length > ++k && c == arr[k])
        ; // lets keep moving, make sure we don't exceed length
      int look = k - i; // owkay sow this the look amount that we will attempt
      say.append(look).append(c); // say it no next line
      i = k; // move i the slow mover to catch up with k
    }
    return say.toString();
  }

  static String LookAndSay(int n) {
    String res = "1"; // starting point
    for (int i = 0; i < n; i++) {
      res = evaluate(res);
      // out.println(res);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(LookAndSay(4));
  }
}
