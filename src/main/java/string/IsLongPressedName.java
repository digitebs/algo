package string;

/** @author john.lim */
public class IsLongPressedName {
  public boolean isLongPressedName(String name, String typed) {

    for (int i = 0, j = 0; i < name.length(); i++) {
      int c1 = 1, c2 = 0;
      while (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1)) {
        i++; // its same increment;
        c1++;
      }
      while (j < typed.length() && name.charAt(i) == typed.charAt(j)) {
        j++;
        c2++;
      }

      if (c1 > c2) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    IsLongPressedName ipn = new IsLongPressedName();
    System.out.println(ipn.isLongPressedName("alex", "aaleex"));
    System.out.println(ipn.isLongPressedName("saeed", "ssaaedd"));
    System.out.println(ipn.isLongPressedName("leelee", "lleeelee"));
    System.out.println(ipn.isLongPressedName("laiden", "laiden"));
    System.out.println(ipn.isLongPressedName("dfuyalc", "fuuyalc"));
  }
}
