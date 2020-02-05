package bit;

public class ReverseBit {
  static int reverseBits(int n) {
    StringBuilder sb =
        new StringBuilder(String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));
    return Long.valueOf(sb.reverse().toString(), 2).intValue();
  }

  public static void main(String[] args) {
    System.out.println(reverseBits(Integer.valueOf("00000010100101000001111010011100", 2)));
  }
}
