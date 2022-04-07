package recursion;


/**
 * If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings.
 *
 * For example:
 * Input: "1123". You need to general all valid alphabet codes from this string.
 *
 * Output List
 * aabc //a = 1, a = 1, b = 2, c = 3
 * kbc // since k is 11, b = 2, c= 3
 * alc // a = 1, l = 12, c = 3
 * aaw // a= 1, a =1, w= 23
 * kw // k = 11, w = 23
 */
public class DecodeString {


  public void decode(String s){
    decode(s,"");
  }

  public void decode(String s, String ans){

    if(s.length() ==0){
      System.out.println(ans);
    }

    if(s.length()> 0) {
      String rem = s.substring(1);
      int val = Integer.parseInt(""+s.charAt(0));
      decode(rem, ans + (char)('a' - 1 + val));
      if (rem.length() > 0) {
        int val2 = Integer.parseInt(""+s.charAt(1));
        int val3= val*10+ val2;
        if(val3 < 26)
        decode(s.substring(2), ans + (char)('a' - 1 + val3));
      }
    }

  }
  public static void main(String[] args) {
    var ds = new DecodeString();
    ds.decode("1123");
  }
}
