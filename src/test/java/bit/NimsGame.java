package bit;

public class NimsGame {
    /* nim is related to keeping the balance in power of 2 bits */
  static String nimsGame(int[] A) {
    int res = 0;
    int n = A.length;
    for (int i = 0; i < n; i++) res ^= A[i];

    // case when Alice is winner
    if (res == 0) return "Second";

    // when Bob is winner
    else return "First";
  }

  public static void main(String[] args) {
      System.out.println(nimsGame(new int[]{3,0,6}));
      // if your the 1st one to move its should be imbalance else you lose
      // keep it always imbalance
      // the job of the 2nd one to move is to keep it always balance to win
      //     1 + 1
      //   0 0 + 0
      //   1 1 + 0
      // even the 1st wins
  }
}
