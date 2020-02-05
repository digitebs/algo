package string;

public class AddBinaryString {
  static String addBinary(String a, String b) {
    if (a.length() < b.length()) a = String.format("%" + b.length() + "s", a).replace(' ', '0');
    else b = String.format("%" + a.length() + "s", b).replace(' ', '0');

    String ans = "";
    int c = 0;
    for (int i = a.length() - 1; i >= 0; i--) {
      int x = Character.digit(a.charAt(i), 2);
      int y = Character.digit(b.charAt(i), 2);
      int sum = x + y + c;
      c = sum / 2;
      int r = sum % 2;
      ans = r + ans;
    }
    return (c == 1 ? c : "") + ans;
  }

  public static void main(String[] args) {
    System.out.println(addBinary("11", "1"));
  }
}
