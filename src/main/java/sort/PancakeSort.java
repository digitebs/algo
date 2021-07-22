package sort;

import java.util.Arrays;

public class PancakeSort {

  /**
   * Sort the array using pancakeSort
   *
   * @param arr array to be modified
   * @return sorted array
   */
  static int[] pancakeSort(int[] arr) {
    // your code goes here
    int k = arr.length;
    while (k > 1) {
      // find  max
      int max = max(arr, k);
      // System.out.println(Arrays.toString(arr) + " "+arr[max]);
      flip(arr, max + 1);
      flip(arr, k);
      k--;
    }
    return arr;
  }

  /**
   * Find the index of max element for the given arr
   * O(n)
   * @param arr
   * @param k
   * @return index of max element
   */
  static int max(int[] arr, int k) {
    int index = 0;
    for (int i = 0; i < k; i++)
      if (arr[index] < arr[i])  index = i;
    return index;
  }

  /**
   * Reverse arr
   * O(n/2)
   * @param arr the array to be reverse
   * @param k exclusive of k
   */
  static void flip(int[] arr, int k) {
    // floor((k+1)/ 2)
    for (int i = 0; i < k / 2; i++) {
      arr[i] = arr[i] ^ arr[k - i - 1] ^ (arr[k - i - 1] = arr[i]);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {2,1};
//    flip(arr, arr.length);
//    System.out.println(Arrays.toString(arr));
    PancakeSort.pancakeSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
