package string;

import java.util.Scanner;

public class MazeFlip {

  // 48 , 24
  private static String flip(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'E':
          sb.append('S');
          break;
        case 'S':
          sb.append('E');
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 1; i <= t; ++i) {
      int m = scan.nextInt();
      String n = scan.next();
      // long start = System.currentTimeMillis();
      String res = flip(n);
      System.out.println("Case #" + i + ": " + res);
      // System.out.println(System.currentTimeMillis() - start);
      // hmm brute force?
    }
  }
}
