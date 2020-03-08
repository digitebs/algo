package regex;

public class ValidateIpAddress {
  static boolean validateIP(String ip) {
    String[] ips = ip.split("\\.",4);
    if (ips.length != 4) return false;

    for (String addr : ips) { // 4
      if (!addr.matches("^[1-9]*\\d{1,2}$")) return false; // n
      int v = Integer.parseInt(addr);
      if (v < 0 || v > 255) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    // 0.04.0.0 -> 0.4.0.0
    System.out.println(validateIP("10.4.0.255"));
    System.out.println(validateIP("10.4.101.255"));
    System.out.println(validateIP("10.4.01.255"));
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
