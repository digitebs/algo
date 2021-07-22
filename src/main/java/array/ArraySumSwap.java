package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ArraySumSwap {

  static int[] sumSwap(int[] arr1, int[] arr2) {

    int s1 = 0;
    int s2 = 0;
    HashSet<Integer> hs = new HashSet<>();

    for (int one : arr1) s1 += one;
    for (int two : arr2) {
      hs.add(two); // plug it in
      s2 += two;
    }
    if ((s1 - s2) % 2 != 0) return null;
    int target = (s1 - s2) / 2;
    System.out.println(target);
    // 1 - 3 = -2
    // one - two = target
    for (int one : arr1) {
      int two = one - target;
      if (hs.contains(two)) {
        return new int[] {one, two};
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(sumSwap(new int[] {4, 1, 2, 1, 1, 2}, new int[] {3, 6, 3, 3})));
  }
}
