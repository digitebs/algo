package string;

/*

Easy*

Given two strings, find the number of common characters between them.

"aabcc" "adcaa"

2a and 1c = 3

 */
public class CommonCharacter {
    int commonCharacterCount(String s1, String s2) {
        int res = 0;
        int[] count = new int[26]; // 26 char max
        for(int i = 0; i < s1.length(); i++)
            count[s1.charAt(i) - 'a']++;
        for(int i = 0; i < s2.length(); i++)
            if(count[s2.charAt(i) - 'a']-- > 0) res++;

        return res;
    }

  public static void main(String[] args) {
    //
      CommonCharacter cc = new CommonCharacter();
      System.out.println(cc.commonCharacterCount("aabcc","adcaa"));
      System.out.println(cc.commonCharacterCount("abca","xyzbac"));
      System.out.println(cc.commonCharacterCount("zzzz","zzzzzzz"));
      System.out.println(cc.commonCharacterCount("xyzbac","abca"));
  }
}
