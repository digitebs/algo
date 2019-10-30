package map;

import java.util.HashMap;

public class LongestSubstringNoDup {
    // using hashmap to store dup index
    static int longestsub(String str) {
        int maxLen = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            maxLen = Math.max(i -  hm.getOrDefault(c,-1) ,maxLen);
            hm.put(c,i); // update the index
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestsub("ABCDEFAGYTUIKGE"));
        System.out.println(longestsub("ABCDEFGE"));
        System.out.println(longestsub("aA"));
    }
}
