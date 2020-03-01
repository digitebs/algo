package map;

import java.util.HashMap;
import java.util.Map;

/*
n a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1,
 then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit,
 but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

// medium

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].

max is 2 basket with unique fruit

3,3,3,1,2,1,1,2,3,3,4

ans: 1,2,1,1,2 = 5
If we started at the first tree or the eighth tree, we would only collect 4 fruits.

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
