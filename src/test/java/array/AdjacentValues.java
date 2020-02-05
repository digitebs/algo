package array;

// you can also use imports, for example:

import java.util.*;

/**
 * Given an unsorted array, find the maximum difference between the successive elements in its
 * sorted form.
 */
public class AdjacentValues {
  public boolean isAdjacent(HashSet<Integer> hs, int a, int b) {
    if (a > b) {
      // swap
      int temp = a;
      a = b;
      b = temp;
    }

    // iterate the gap
    for (int i : hs) { // 40k this is the bottle neck
      if (i > a + 1 && i < b) return false;
    }
    return true;
  }

  public int solution(int[] A) {
    // write your code in Java SE 8
    int max = -1;
    HashSet<Integer> hs = new HashSet<>();
    for (int value : A) {
      hs.add(value); // store all unique values;
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (isAdjacent(hs, A[i], A[j])) max = Math.max(max, j - i);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(new AdjacentValues().solution(new int[] {3, 6, 9, 120}));
  }
}
