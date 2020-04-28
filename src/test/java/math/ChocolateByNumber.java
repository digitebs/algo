package math;

// euclidean is solve by using gcd
public class ChocolateByNumber {
  /**
   * using loop N
   *
   *
   *  given circular N candies (numbered 0-N), everytime you eat the candy the wrapper
   *  remains then you to move M position of candy,
   *  return the number of candies eaten before an empty wrapper is encountered.
   *
   * @param N
   * @param M
   * @return
   */
  public int cycleLinear(int N, int M) {
    int i = 0;
    int ct = 0;
    int[] arr = new int[N];
    while (arr[i] != -1) {
      arr[i] = -1; // marked
      i = (i + M) % N;
      ct++;
    }
    return ct;
  }
  // 11 4
  // 4 3
  // 3 1
  // 1 0
  int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  int cycleConstant(int N, int M) {
    return N / gcd(N, M);
    // if(N >= M) return N/f;
    // else return N/f;
    // return cycleLinear(N/f,M/f);
    // return c;
  }

  //
  // 3
  // 0 4 8 12
  // 1 5 9 13
  //
  // increase by 1 == 4-3
  // 4/1 == 4
  //

  // 0 4 8
  // 1 5 9
  // 2 6 10
  // 3 7 11 -> 4

  // 0 4 8
  // 2 6 -> 0
  public static void main(String[] args) {
    // 13 4
    ChocolateByNumber cbn = new ChocolateByNumber();
    System.out.println(cbn.cycleLinear(21, 12));
    System.out.println(cbn.cycleConstant(21, 12));
  }
}
