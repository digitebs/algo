package bit;

/*
    given integer n count the number of bits
 */
public class HammingWeight {
  // bit count
  int hammingWeight(int n) {
    int count = 0;
    do if ((n & 1) == 1) count++;
    while ((n >>>= 1) > 0);
    return count;
  }

  public static void main(String[] args) {
    //
    HammingWeight hw = new HammingWeight();
    System.out.println(hw.hammingWeight(3));
    System.out.println(hw.hammingWeight(8));
  }
}
