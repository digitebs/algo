package dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 */
public class CountingBits {

  int[] count(int n){
    if(n==0){
      return new int[]{0};
    }

    var a = new int[n+1];
    a[1] = 1;

    for(int i=2; i < n+1; i++){
      a[i] = a[i/2] + i%2;
    }

    return a;
  }
  public static void main(String[] args) {
    CountingBits cb = new CountingBits();
    System.out.println(IntStream.of(cb.count(2)).boxed().collect(Collectors.toList()));
  }
}
