package string;

import java.util.stream.Stream;

public class AddString {
    public String addStrings(String num1, String num2) {
      int i= num1.length();
      int j =num2.length();
      String str = "";
      int c = 0;
      while(i >  0 || j > 0){
        int a = 0;
        int b = 0;

        if(i-1 >= 0) a = num1.charAt(--i)-'0';
        if(j-1 >= 0) b = num2.charAt(--j)-'0';

        int r = (c + a +b) %10;
        str = r + str;
        c = (c + a + b)/10;
      }

      return (c > 0 ? c :"") + str;
    }

  public static void main(String[] args) {

      AddString as = new AddString();
      System.out.println(as.addStrings("11", "1"));
  }
}
