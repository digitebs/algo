package array;

import java.util.Arrays;

/*
  given 2 array find teh intersection bewteen them, arrays can contain duplicate
 */
public class ArrayIntersection {

  void intersection(int[] a, int[] b) {
    Arrays.sort(a); // nlogn
    Arrays.sort(b); // nlogn
    int i = 0, j = 0;
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        System.out.println(a[i++]);
        j++;
      } // support dups
      else if (a[i] > b[j]) j++; // increase j
      else i++;
    }
  }

  public static void main(String[] args) {
    new ArrayIntersection().intersection(new int[] {1, 2,2,2, 3, 4, 5}, new int[] {2,2,2,2, 5});
  }
}
