package string;

public class MaxRemoveKdigit {
  public String removeKdigits(String num, int k) {
    // 543999999
    StringBuilder sb = new StringBuilder(num);
    int i = 0, rem = sb.length() - k;
    while (i < sb.length() - 1 && sb.length() > rem)
      if (sb.charAt(i) < sb.charAt(++i)) sb.deleteCharAt(--i == 0 ? i : i--);
    while (sb.length() > rem) sb.deleteCharAt(sb.length() - 1);
    while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
    return sb.length() == 0 ? "0" : sb.toString();
  }

  // remove min digit, constraint: num is  >=10
  public int deleteDigit(int num) {
    // 543999999
    StringBuilder sb = new StringBuilder(String.valueOf(num));
    for (int i = 0; i < sb.length() - 1; i++)
      if (sb.charAt(i) < sb.charAt(i + 1)) {
        return Integer.parseInt(sb.deleteCharAt(i).toString());
      }
    return Integer.parseInt(sb.deleteCharAt(sb.length() - 1).toString());
  }


  public static void main(String[] args) {

    System.out.println(new MaxRemoveKdigit().removeKdigits("3594222", 3));
    System.out.println(new MaxRemoveKdigit().removeKdigits("152", 1));

    System.out.println(new MaxRemoveKdigit().deleteDigit(152));
  }
}
