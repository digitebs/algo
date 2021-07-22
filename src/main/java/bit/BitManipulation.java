package bit;

public class BitManipulation {
  int mirrorBits(int n) {

    int ans = 0;
    do {
      ans = (ans << 1) + (n & 1);
    } while ((n >>>= 1) > 0);
    return ans;
  }

  int killKthBit(int n, int k) {
    return n & ~(1 << k - 1);
  }

  // bit count
  int hammingWeight(int n) {
    int count = 0;
    do if ((n & 1) == 1) count++;
    while ((n >>>= 1) > 0);
    return count;
  }

  int secondRightmostZeroBit(int n) {
    return ~(n | n + 1) & (n | n + 1) + 1;
  }

  // 0xAAAAAAAA = 10101010...
  // 0x55555555 = 01010101...
  int swapAdjacentBits(int n) {
    return (((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1));
  }

  int differentRightmostBit(int n, int m) {
    return (n ^ m) & -(n ^ m);
  }

  int equalPairOfBits(int n, int m) {
    return  ~(n^m) & ((n^m)+1);
  }

  public static void main(String[] args) {
    BitManipulation bm = new BitManipulation();
    System.out.println(bm.mirrorBits(97));
    System.out.println(bm.killKthBit(37, 3));
    System.out.println(bm.hammingWeight(3));
    System.out.println(bm.hammingWeight(8));

    System.out.println((11 ^ 13) - 1);
  }
}
