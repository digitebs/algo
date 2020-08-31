package combination;

import java.util.ArrayList;
import java.util.Arrays;

/** return all combination of array from i to n, where k is the number of combination */
public class CombinationArray {
  public void combine(
      ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int i, int n, int k) {
    if (arr.size() == k) res.add(arr);
    else {
      for (int j = i; j <= n; j++) {
        ArrayList<Integer> a = new ArrayList<>(arr);
        a.add(j);
        combine(res, a, j + 1, n, k);
      }
    }
  }

  public void combine2(
      ArrayList<ArrayList<Integer>> res, ArrayList<Integer> src, ArrayList<Integer> arr, int i, int k) {
    if (arr.size() == k) res.add(arr);
    else {
      for (int j = i; j < src.size(); j++) {
        ArrayList<Integer> a = new ArrayList<>(arr);
        a.add(src.get(j));
        combine2(res,src, a, j + 1, k);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> src = new ArrayList<>(Arrays.asList(5,6,7,8));
    ArrayList<Integer> arr = new ArrayList<>();
    CombinationArray ca = new CombinationArray();

    for(int i =1; i< src.size();i++ )
    ca.combine2(res,src, arr, 0, i);

    /* Collections.sort(res, (o1, o2) -> {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int c = o1.get(i).compareTo(o2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    });*/
    System.out.println(res);
  }
}
