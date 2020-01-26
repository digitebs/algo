package sort;

import java.util.Arrays;

/*
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */
public class AlienSorted {

    /*
    order = "cba"
    word = "abcd"
    Output: "dcba"
     */
    public String isAlienSorted(String word, String order) {
        // use some string sorter
        Character[] cp =
                word.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(cp,(a, b) -> {
            int c1 = order.indexOf(a);
            int c2 = order.indexOf(b);
            return c1-c2;
        });
        StringBuilder sb = new StringBuilder(cp.length);
        for (Character c : cp) sb.append(c.charValue());
        return sb.toString();
    }

    public boolean isAlienSorted(String[] words, String order) {
        // use some string sorter
        String[] cp = Arrays.copyOf(words, words.length);
        Arrays.sort(cp,(a, b) -> {

            int i =0;
            int j =0;
            while(i < a.length() && j < b.length()){
                int c1 = order.indexOf(a.charAt(i));
                int c2 = order.indexOf(b.charAt(j));

                if(c1 == c2){
                    i++;
                    j++; //owkay
                }else {
                    return c1-c2;
                }
            }
            if(i == a.length()) return -1;
            else return 1;
        });
        return Arrays.equals(words, cp);
    }

    public static void main(String[] args) {
        System.out.println(new AlienSorted().isAlienSorted(new String[]{
                "apple",
                "app"
        },"abcdefghijklmnopqrstuvwxyz"));
    }
}
