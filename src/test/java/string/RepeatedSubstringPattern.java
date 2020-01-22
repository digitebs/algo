package string;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and
 * appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i=len/2;i>0;i--) {

            if(len%i == 0) {
                String pre = s.substring(0,i);
                int nor = len/i;
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<nor;j++) {
                    sb.append(pre);
                }

                if(sb.toString().equals(s)) {
                    return true;
                }

            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }
}
