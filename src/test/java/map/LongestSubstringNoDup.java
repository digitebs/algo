package map;

import java.util.HashMap;

public class LongestSubstringNoDup {
    // using hashmap to store dup index
    // a b c d e f g h c a
    static int longestsub(String str) {
        int maxLen = 0;
        int start = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            start = Math.max(start,hm.getOrDefault(c, start));
            maxLen = Math.max(i -  start ,maxLen);
            hm.put(c,i); // update the index
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestsub("ABCDEFAGYTUIKGE"));
        System.out.println(longestsub("ABCDEFGE"));
        System.out.println(longestsub("aA"));
        System.out.println(longestsub("abcaacefgh"));
        System.out.println(longestsub("abcdacefgh"));
        System.out.println(longestsub("abdaeedfg"));
    }
}
