package map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * given a pattern:
 *      aaba
 * see if:
 *      apple apple orange apple true
 * matches
 * @author john.lim
 */
public class StringInPattern {

    static boolean isMatch2(String a, String s) {
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

        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> hm2 = new HashMap<>();
        for (int i = 0, l = 0; i < words.length; i++) {
            if (!hm2.containsKey(words[i])) {
                hm2.put(words[i], l++);
            }
            result.append(rev.get(hm2.get(words[i])));
        }

        System.out.println(hm + " " + hm2);
        System.out.println(result);
        return result.toString().equals(a);
    }

    public static boolean isMatch(String pattern, String input) {
        char[] ch = pattern.toCharArray();
        String[] word = input.split(" ");
        if (ch.length != word.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            if (!map.containsKey(ch[i])) {
                map.put(ch[i], word[i]);
            } else {
                if (!map.get(ch[i]).equalsIgnoreCase(word[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isMatch("aaba", "apple apple orange apple"));
        System.out.println(isMatch("aaba", "apple apple orange big"));
    }
}
