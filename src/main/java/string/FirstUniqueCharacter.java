package string;

import java.util.HashMap;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * @author john.lim
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i = 0 ; i < s.length(); i++){
            if(hm.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
  public static void main(String[] args) {
    //
      FirstUniqueCharacter fuc =  new FirstUniqueCharacter();
      System.out.println(fuc.firstUniqChar("raarkutenk"));

  }
}
