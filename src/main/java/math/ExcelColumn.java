package math;

public class ExcelColumn {
  /*
    nice problem for interview!
   */
  public static String convertToTitle(int c) {
    StringBuilder sb = new StringBuilder();

    do {
      sb.append((char) ('A' + (--c % 26))); // subtract t by 1 before mod
    } while ((c /= 26) > 0);
    return sb.reverse().toString();
  }

  public static int titleToNumber(String s) {
    int result = 0;
    for (char c : s.toCharArray()) {
      result = result * 26 + (c - 'A') + 1; // 1line only :(
    }
    return result;
  }
  //

  public static void main(String[] args) {
    System.out.println(convertToTitle(1));
    System.out.println(convertToTitle(26));
    System.out.println(convertToTitle(500));
    System.out.println(titleToNumber("AA"));
  }
}
