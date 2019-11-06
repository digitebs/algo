package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by johnlim on 1/2/17.
 */
public class LeetCodeString {

    @Test
    public void lengthOfLongestSubstring()
    {
       /* System.out.println("ll"+lengthOfLongestSubstring("a"));
        System.out.println("ll"+lengthOfLongestSubstring("au"));
        System.out.println("ll"+lengthOfLongestSubstring("bdb"));
        System.out.println("ll"+lengthOfLongestSubstring("aa"));*/
        System.out.println("ll"+lengthOfLongestSubstring("dvdf"));
        /*System.out.println("ll"+lengthOfLongestSubstring("tmmzuxt"));
        System.out.println("ll"+lengthOfLongestSubstring("tmmzuxtmbcdegtmbcdekgt"));
        System.out.println("ll"+lengthOfLongestSubstring("abcabcbb"));
        System.out.println("ll"+lengthOfLongestSubstring("nfpdmpi"));
        System.out.println("ll"+lengthOfLongestSubstring("uqinntq"));*/

    }
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[256];
        for (int i = 0; i < index.length; i++) {
            index[i]=-1;
        }
        int len =0;
        int ctr=0;
        int j=0;

        if(s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        for (int i = 0; i < s.length(); i++) {


           // System.out.println(ctr);
            if(index[s.charAt(i)]!=-1 && index[s.charAt(j)] <= index[s.charAt(i)]) {
               // index[s.charAt(j)] = -1;
                ctr=i-index[s.charAt(j)];
                len=Math.max(len,ctr);
                //index = new int[256];
                //i=++j;
                j=index[s.charAt(i)];
              //  index[s.charAt(i)] = i;
                System.out.println(i+" "+j+" "+s.charAt(j)+" "+index[s.charAt(j)] + " "+ctr+ " "+len);

            }
            index[s.charAt(i)] = i;
        }
        System.out.println("j:"+j+" "+len+ " "+ s.length()+" "+index[s.charAt(j)]);
        return len=Math.max(len,s.length()-index[s.charAt(j)]);
    }

    public static final  void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Test
    public void removeDuplicates() {
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{1,1,2,2}));
        System.out.println(removeDuplicates(new int[]{1,1,2,3,3,4,350,351}));
    }
    public int removeDuplicates(int[] nums) {
        int j=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[j] != nums[i+1]){
                swap(nums,++j,i+1);
            }
        }
        return j+1;
    }
}
