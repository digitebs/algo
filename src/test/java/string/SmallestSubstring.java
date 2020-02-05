package string;

import java.util.HashMap;

/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

 */
public class SmallestSubstring {
    /*
        sliding window but uses hashmap, very difficult with lots of vars
     */
    static String getShortestUniqueSubstring(char[] arr, String str) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int i =0;
        int j =0;
        int needCharacter=arr.length; //
        String res ="";
        int min = Integer.MAX_VALUE;

        for (char c:
             arr) {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        while(  j>=i){
            // System.out.println(i+" "+j);
            if(needCharacter <=0){
               char  c=str.charAt(i);
                if(hm.containsKey(c)) {
                    hm.computeIfPresent(c,(k,v)-> ++v);
                    //hm.put(c, hm.get(c) + 1); // yes subtract
                    if (hm.get(c) > 0) needCharacter++;
                   // System.out.println("brr "+ needCharacter);
                    if(needCharacter > 0 && min > j-i){
                            min = j-i;
                            res = str.substring(i,j);
                     //       System.out.println("i: "+res+" "+j +" "+i+ " "+hm);
                    }
                }
                i++;
            }else if(j < str.length()){
                char c = str.charAt(j);
                if(hm.containsKey(c)){
                    hm.computeIfPresent(c,(k,v)-> --v);
                    //hm.put(c,hm.get(c)-1); // yes subtract
                    if(hm.get(c) >= 0) needCharacter--;
                    if(needCharacter < 0 && min > j-i){
                            min = j-i;
                            res = str.substring(i,j);
                      //      System.out.println("j: "+res+" "+j +" "+i+ " "+hm);
                    }
                }
                j++;
            }else{
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
      //  System.out.println(new SmallestSubstring().getShortestUniqueSubstring(new char[]{'x','y','z'},"xxzxxxkyzazyz"));
        System.out.println(new SmallestSubstring().getShortestUniqueSubstring(new char[]{'x','y','z'},"zzxyzx"));
    }
}
