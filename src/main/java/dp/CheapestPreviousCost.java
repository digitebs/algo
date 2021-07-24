package dp;

import java.util.Arrays;

/** Created by johnlim on 17/5/17. */
public class CheapestPreviousCost {

  /**
   * dynamic programming where you store the cheapest previous cost
   *
   * @param A
   * @return
   */
  public int solution(int[] A) {
    int[] cost = new int[30];
    int[] norm = new int[30];

    if (A.length == 0) return 0; // empty
    for (int i = 0; i < A.length; i++) {
      norm[A[i] - 1] = 1;
    }

    System.out.println(Arrays.toString(norm));
    A = norm; // normalize
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        cost[i] = (i == 0) ? 0 : cost[i - 1];
      } else {
        int cost1 = (i == 0) ? 2 : cost[i - 1] + 2;
        int cost7 = (i - 7 < 0) ? 7 : cost[i - 7] + 7;
        cost[i] = Math.min(cost1, cost7);
      }
      System.out.println(Arrays.toString(cost));
    }
    return Math.min(cost[A.length - 1], 25);
  }

  public void test() {
    System.out.println("shit" + solution(new int[] {1, 2, 4, 5}));
  }
}
