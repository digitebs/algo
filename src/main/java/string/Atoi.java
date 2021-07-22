package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {
  /*
     convert string to int
  */
  public int myAtoi(String str) {
    Matcher m = Pattern.compile("^\\s*([-+]?[0-9]+).*").matcher(str);
    return m.find() ? (int) Double.parseDouble(m.group(1)) : 0;
  }

  public static void main(String[] args) {
    System.out.println((int) Double.parseDouble("-91283472332"));
  }
}
