package matrix;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
  public String convert(String s, int numRows) {
    int j=0;
    List<StringBuilder> rows = new ArrayList<>();

    for (int k = 0;k < Math.min(numRows, s.length()); k++)
      rows.add(new StringBuilder());

    while(j< s.length()){
      int i=0;
      while(i < numRows && j< s.length()){
        rows.get(i++).append(s.charAt(j++));
      }
      i--;
      while(i > 1 && j< s.length()){
        rows.get(--i).append(s.charAt(j++));
      }
    }

    StringBuilder ret = new StringBuilder();
    for (StringBuilder row : rows) ret.append(row);
    return ret.toString();
  }

  public static void main(String[] args) {
    ZigZagConversion zzc = new ZigZagConversion();
    assert zzc.convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR");
    // System.out.println(zzc.convert("PAYPALISHIRING",3));
  }
}
