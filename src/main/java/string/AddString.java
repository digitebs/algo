package string;

import java.util.stream.Stream;

/*
    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

    // no zero in front

 */
public class AddString {
    public String addStrings(String num1, String num2) {
      int i= num1.length();
      int j =num2.length();
      String str = "";
      int c = 0;
      while(i >  0 || j > 0){
        int a = 0;
        int b = 0;

        if(i > 0) a = num1.charAt(--i)-'0';
        if(j > 0) b = num2.charAt(--j)-'0';

        int s = c + a +b;
        str = s%10 + str;
        c = s/10;
      }

      return (c > 0 ? c :"") + str;
    }

  public static void main(String[] args) {

      AddString as = new AddString();
      System.out.println(as.addStrings("11", "1"));
      System.out.println(as.addStrings("56", "21"));
      System.out.println(as.addStrings("123456788888889", "1"));
      System.out.println(as.addStrings("999", "1"));
  }
}
