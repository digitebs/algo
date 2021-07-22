package bit;

/*
8bits per character

binary to string

"010010000110010101101100011011000110111100100001"

output:
"Hello!"
 */
public class BinaryCode {
  String messageFromBinaryCode(String code) {
    String str = "";
    String res = "";
    for (int i = 1; i <= code.length(); i++) {
      str += code.charAt(i - 1);
      if (i == code.length() || i % 8 == 0) {
        int c = base2(str);
        res += (char) c; // to char :)
        str = ""; // empty
      }
    }

    return res;
  }

  // convert string to base 2
  int base2(String bits) {
    int ans = 0;
    for (int i = bits.length() - 1, f = 1; i >= 0; i--) {
      ans += f * (bits.charAt(i) - '0');
      f <<= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    //
    BinaryCode bc = new BinaryCode();

    System.out.println(bc.base2("01001000"));
    System.out.println(bc.messageFromBinaryCode("010010000110010101101100011011000110111100100001"));
  }
}
