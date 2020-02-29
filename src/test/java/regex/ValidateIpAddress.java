package regex;

public class ValidateIpAddress {
  static boolean validateIP(String ip) {
    // your code goes here
    // 2.0.2
    // 2.0.0.0.0.0
    // +9.+9.+9.+5
    String[] ips = ip.split("\\.",4);
    // System.out.println(ips.length);
    if (ips.length != 4) return false;

    for (String addr : ips) { // 4
      if (!addr.matches("^[1-9]*\\d$")) return false; // n
      // [1-9]*[\d] // without a pad of zero
      int v = Integer.parseInt(addr);
      if (v < 0 || v > 255) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    // 0.04.0.0 -> 0.4.0.0
    System.out.println(validateIP("10.4.0.255"));
    System.out.println(validateIP("192.168.-50.4"));
    System.out.println(validateIP("192.168.256.4"));
    System.out.println(validateIP("192.168.0.+4"));
    System.out.println(validateIP("192.168.0.34.45"));
    System.out.println(validateIP("192.600.0.34"));
    System.out.println(validateIP("192.168"));
    System.out.println(validateIP("192.168..4"));
    System.out.println(validateIP("192.168.aaa.4"));
  }
}
