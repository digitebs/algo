package string;

import java.util.Arrays;

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


    /**
     *
     * lps using dp storing the  len in an array
     */
    static void computeLPSArray(String str, int M,
                                int lps[])
    {
        // lenght of the previous
        // longest prefix suffix
        int len = 0;

        int i;

        lps[0] = 0; // lps[0] is always 0
        i = 1;

        // the loop calculates lps[i]
        // for i = 1 to M-1
        while (i < M)
        {
            System.out.println(i+" "+len +" "+ str.charAt(i)+ " "+ str.charAt(len)+" "+ Arrays.toString(lps));
            if (str.charAt(i) == str.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0)
                {
                    // This is tricky. Consider the
                    // example AAACAAAA and i = 7.
                    len = lps[len-1];

                    // Also, note that we do
                    // not increment i here
                }
                else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static boolean isRepeat(String str)
    {
        // Find length of string and create
        // an array to store lps values used in KMP
        int n = str.length();
        int lps[] = new int[n];

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(str, n, lps);

        System.out.println(Arrays.toString(lps));
        // Find length of longest suffix
        // which is also prefix of str.
        int len = lps[n-1];

        // If there exist a suffix which is also
        // prefix AND Length of the remaining substring
        // divides total length, then str[0..n-len-1]
        // is the substring that repeats n/(n-len)
        // times (Readers can print substring and
        // value of n/(n-len) for more clarity.

        System.out.println(n +" "+len);
        // mode check if its repeatable of x times
        return (len > 0 && n%(n-len) == 0)? true: false;
    }

    public static void main(String[] args) {
        // EEEKS EEEKS EEEKS
        System.out.println(new RepeatedSubstringPattern().isRepeat("EEEKSEEEKSEEEKS"));
       // System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }
}
