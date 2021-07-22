package string;

/*
given  two binary string add them together.

Input:
"11" ,"1"

Output: "100"
 */
public class AddBaseString {
  static int BASE = 3;
  static String addBinary(String a, String b) {
    a = String.format("%" + b.length() + "s", a).replace(' ', '0');
    b = String.format("%" + a.length() + "s", b).replace(' ', '0');

    String ans = "";
    int c = 0;
    for (int i = a.length() - 1; i >= 0; i--) {
      int x = Character.digit(a.charAt(i), BASE);
      int y = Character.digit(b.charAt(i), BASE);
      int sum = x + y + c;
      c = sum / BASE;
      int r = sum % BASE;
      ans = r + ans;
    }
    return (c == 1 ? c : "") + ans;
  }

  public static void main(String[] args) {

    System.out.println(addBinary("1", "10002"));
    System.out.println(addBinary("12", "2"));
    System.out.println(addBinary("1100101010010", "01010100101001010"));
  }
}
