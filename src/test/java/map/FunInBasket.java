package map;

import java.util.HashMap;
import java.util.Map;

/*

In a row of trees, the i-th tree produces fruit with type tree[i]

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].

max is 2 basket with unique fruit

 */
public class FunInBasket {
  public int totalFruit(int[] tree) {
    HashMap<Integer, Integer> hs = new HashMap<>(); // can only store 2
    int max = 0, count = 0;
    int prev = -1;
    for (int i = 0; i < tree.length; i++) {
      hs.put(tree[i], i);
      count++;
      if (hs.size() > 2) {
        int[] kv = new int[] {-1, Integer.MAX_VALUE};
        hs.forEach(
            (k, v) -> {
              if (kv[1] > v) {
                kv[1] = v;
                kv[0] = k;
              }
            });
        int temp = hs.remove(kv[0]);
        count = count - temp + prev; // find the min and remove
        prev = temp;
      }
      max = Math.max(count, max);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(new FunInBasket().totalFruit(new int[] {1, 2, 3, 2, 2}));
  }
}
