package bit;

/**
 * 010 (2) 010 (2) --- 111 001 (1)
 *
 * <p>001 // returns (1) itself
 *
 * <p>xor returns itself if no pair
 */
public class PairXor {
  static int pair(int[] A) {
    int prd = A[0];
    for (int i = 1; i < A.length; i++) {
      prd ^= A[i];
    }
    return prd;
  }

  public static void main(String[] args) {
    System.out.println(PairXor.pair(new int[] {9, 3, 9, 3, 9, 7, 9}));
  }
}
