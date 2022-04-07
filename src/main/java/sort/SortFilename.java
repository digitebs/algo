package sort;

import java.util.Arrays;

/**
 * sort filename with number.
 *
 * lexographical order except if theres is anumber. then the number a < number bb
 *
 */
public class SortFilename {


  public String[] sort(String[] filenames){
    Arrays.sort(filenames,(a,b)->{
      int i = 0;
      while(i < a.length() && i < b.length()){
        var digit1 = Character.isDigit(a.charAt(i));
        var digit2 = Character.isDigit(b.charAt(i));
        var str1 = new StringBuilder();
        var str2 = new StringBuilder();
        if(digit1 && digit2) {
          while (digit1 || digit2) {
            if (digit1) {
              str1.append(a.charAt(i));
            }
            if (digit2) {
              str2.append(b.charAt(i));
            }
            i++;
            digit1 = Character.isDigit(a.charAt(i));
            digit2 = Character.isDigit(b.charAt(i));
          }
          int c = Integer.parseInt(str1.toString()) - Integer.parseInt(str2.toString());
          if (c != 0) {
            return c;
          }
        }else{
          int c = a.charAt(i) - b.charAt(i);
          i++;
          if( c !=0) return c;
        }
      }

      return a.length()-b.length();
    });

    return filenames;
  }

  public static void main(String[] args) {
    var sf = new SortFilename();
    String[] ans= sf.sort(new String[]{
        "aaaaa.gif",
        "b10a11.gif",
        "b10a10.gif",
        "a100.gif",
        "a2ab.gif",
        "aaa.gif"

    });

    System.out.println(Arrays.toString(ans));
  }
}
