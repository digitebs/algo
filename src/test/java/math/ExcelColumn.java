package math;

public class ExcelColumn {
  public static String convertToTitle(int a) {
    String str = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
    StringBuilder sb = new StringBuilder();
    for (int t = a; t > 0; t /= 26) { // 26 letters
      sb.append(str.charAt(t % 26));
      if (t % 26 == 0) t -= 1; // backtrack!
    }
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
    System.out.println(titleToNumber("AAA"));
  }
}
