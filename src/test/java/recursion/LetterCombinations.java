package recursion;

import java.util.ArrayList;
import java.util.List;


/*
Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive,
 return all possible letter combinations that the number could represent.

 Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

using backtracking of string builder
 */
public class LetterCombinations {
    private String[][] numchar = new String[][]
            {
                    {""}, {""},           // digit 0-9
                    {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
                    {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}
            };

    private List<String> res = new ArrayList<>();

    public void backtrack(String digits, int k, StringBuilder sb) {
        if (digits.length() == sb.length()) {
            res.add(sb.toString());
            return;
        }

        String chars[] = numchar[digits.charAt(k) - '0'];
        for (String c : chars) {
            backtrack(digits, k + 1, sb.append(c));
            sb.deleteCharAt(sb.length() - 1); // remove the last one
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }
}
