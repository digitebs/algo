package map;

import java.util.HashMap;
import java.util.Map;

public class BreakWord {

    private static boolean breakWord(String s, HashMap<String,Integer> hm){
        if(s.length() == 0)  return true;
        for(Map.Entry<String,Integer> e : hm.entrySet()){
            if(s.startsWith(e.getKey()) && e.getValue()!=0) {
                HashMap<String,Integer> newMap = new HashMap<>(hm);
                newMap.put(e.getKey(),e.getValue()-1);
                if(breakWord(s.substring(e.getKey().length()),newMap))
                    return true; // if its true cut out
            }
        }


        return false;

    }
    public static void main(String[] args) {

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("abc",3);
        hm.put("ab",2);
        hm.put("abca",1);
        String s = "abcabcabcabca";

        System.out.println(breakWord(s,hm));


        hm = new HashMap<>();
        hm.put("abc",3);
        hm.put("ab",2);
        s = "abcabab";

        System.out.println(breakWord(s,hm));

        hm = new HashMap<>();
        hm.put("abc",3);
        hm.put("ab",2);
        hm.put("abca",1);
        s = "abcx";

        System.out.println(breakWord(s,hm));

    }
    
}
