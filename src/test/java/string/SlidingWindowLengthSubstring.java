package string;

import java.util.HashMap;


/**
 * Slidng window!!!
 */
public class SlidingWindowLengthSubstring {
    static int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> hm = new HashMap<>(); // we store teh caharcter of string
        int ans = 0;
        for(int j=0,i = 0;j < s.length();j++){
            char c = s.charAt(j);
            if(hm.containsKey(c)){
                i = Math.max(hm.get(c),i); // i is upto where
            }
            ans = Math.max(ans,j - i +1);
            hm.put(c,j + 1);// update the character last position
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abba"));
    }
}
