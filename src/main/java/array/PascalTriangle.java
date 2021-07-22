package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class PascalTriangle {
  private static ArrayList<Integer> getRow(int a) {
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i <= a; i++) {
      if (i == 0) res.add(1);
      else {
        int cur = res.get(0);
        for (int j = 1; j < res.size(); j++) {
          int next = res.get(j);
          res.set(j, cur + next);
          cur = next;
        }
        res.add(cur);
      }
    }
    return res;
  }

  private static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows >= 1) result.add(Collections.singletonList(1));
    for (int i = 1; i < numRows; i++) {
      List<Integer> arr = new ArrayList<>();
      arr.add(1); // cross border
      for (int j = 1; j < i; j++) arr.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
      arr.add(1); // cross border
      result.add(arr);
    }
    return result;
  }

  public static void main(String[] args) {
    out.println(Arrays.toString(generate(6).toArray()));
    // out.println(Arrays.toString(getRow(5).toArray()));
  }
}
