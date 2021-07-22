package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compartment {

  public List<Integer> compartment(String s, List<Integer> startIndices, List<Integer> endIndices) {

    List<Integer> ans = new ArrayList<>();
    int n = startIndices.size();
    for (int i = 0; i < n; i++) {
      ans.add(count(s, startIndices.get(i), endIndices.get(i)));
    }

    return ans;
  }

  public int count(String s, int i, int j) {
    boolean star = false;
    int count = 0;
    int result = 0;

    while (i <= j) {

      char c = s.charAt(i - 1);

      if (c == '|') {
        star = true;
        result += count;
        count = 0;
      } else if (star == true) {
        count++;
      }
      i++;
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> startIndices = Arrays.asList(1, 1);
    List<Integer> endIndices = Arrays.asList(5, 6);
    Compartment c = new Compartment();
    System.out.println(c.compartment("|**|*|*", startIndices, endIndices));

    startIndices = Arrays.asList(2, 7, 8);
    endIndices = Arrays.asList(9, 14, 20);
    System.out.println(c.compartment("******|******||***||||||||**|8|", startIndices, endIndices));

    startIndices = Arrays.asList(1);
    endIndices = Arrays.asList(6);
    System.out.println(c.compartment("*|*|*|", startIndices, endIndices));
  }
}
