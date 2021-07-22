package combination;

import java.util.LinkedList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParenthesis {
  LinkedList<String> arr = new LinkedList<>();

  public void gen(StringBuilder sb, int o, int c) {

    if (o == 0 && c == 0) {
      arr.add(sb.toString());
      return; // stop opening
    }
    if (o > 0) {
      gen(sb.append('('), o - 1, c);
      sb.deleteCharAt(sb.length() - 1); // backtracking
    }
    if (c > o) {
      gen(sb.append(')'), o, c - 1);
      sb.deleteCharAt(sb.length() - 1); // backtracking
    }
  }

  public List<String> generateParenthesis(int n) {
    gen(new StringBuilder(n * 2), n, n); // start blank
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(new GenerateParenthesis().generateParenthesis(3));
  }
}
