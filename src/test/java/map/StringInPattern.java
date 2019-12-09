package map;

import java.util.HashMap;

/**
 * @author john.lim
 */
public class StringInPattern {

    // aaba
    // apple apple orange apple true
    static boolean inPattern(String a, String s) {

        String[] words = s.split(" ");
        if (a.length() != words.length) return false;

        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Integer, Character> rev = new HashMap<>();
        for (int i = 0, k = 0; i < words.length; i++) {
            if (!hm.containsKey(a.charAt(i))) {
                rev.put(k, a.charAt(i));
                hm.put(a.charAt(i), k++);
            }
        }

        String result = "";
        HashMap<String, Integer> hm2 = new HashMap<>();
        for (int i = 0, l = 0; i < words.length; i++) {
            if (!hm2.containsKey(words[i])) {
                hm2.put(words[i], l++);
            }
            result += rev.get(hm2.get(words[i]));
        }

        System.out.println(hm + " " + hm2);
        System.out.println(result);
        return result.equals(a);
    }

    public static void main(String args[]) {
        System.out.println(inPattern("aaba", "apple apple orange apple"));
        System.out.println(inPattern("aaba", "apple apple orange big"));
    }
}
