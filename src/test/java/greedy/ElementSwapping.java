package greedy;

import java.util.Arrays;

/*
   Given a sequence of n integers arr, determine the lexicographically
   smallest sequence which may be obtained from it after performing at most k element swaps,
   each involving a pair of consecutive elements in the sequence.

   k = 2
   arr = [5, 3, 1]
   output = [1, 5, 3]

   k = 3
   arr = [8, 9, 11, 2, 1]
   output = [2, 8, 9, 11, 1]
*/
public class ElementSwapping {

  /**
   * find the min index in arr given s and e
   * @param arr
   * @param s start index
   * @param e end index
   * @return min index
   */
  int findMinIndex(int[] arr, int s, int e) {
    int i = s;
    while (s <= e) {
      if (arr[i] > arr[s]) i = s;
      s++;
    }

    return i; // min index
  }

  void swap(int[] arr, int to, int from) {
    int temp = arr[from];
    while (from > to) {
      arr[from] = arr[from - 1];
      from--;
    }
    arr[to] = temp;
  }

  int[] findMinArray(int[] arr, int k) {
    // Write your code here
    int i = 0;
    int n = arr.length;
    while (k > 0 && i < n) {
      int j = findMinIndex(arr, i, k);
      swap(arr, i, j);
      k -= j - i;
      i++;
    }

    return arr;
  }

  public static void main(String[] args) {
    ElementSwapping es = new ElementSwapping();
    System.out.println(Arrays.toString(es.findMinArray(new int[] {5, 3, 1}, 2)));
    System.out.println(Arrays.toString(es.findMinArray(new int[] {8, 9, 11, 2, 1}, 3)));
  }
}
