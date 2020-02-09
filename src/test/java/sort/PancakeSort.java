package sort;

import java.util.Arrays;

public class PancakeSort {
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

  /*
   you need to find the max
  */
  static int max(int[] arr, int k) {
    int idx = 0;
    for (int i = 0; i < k; i++) {
      if (arr[idx] < arr[i]) {
        //  max = arr[i];
        idx = i;
      }
    }
    return idx;
  }

  static void flip(int[] arr, int k) {
    // floor((k+1)/ 2)
    for (int i = 0; i < k / 2; i++) {
      // System.out.println(k -i);
      int temp = arr[i];
      arr[i] = arr[k - i - 1]; // swap
      arr[k - i - 1] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 5, 4, 3, 2};
    // flip(arr, 5);
    // System.out.println(Arrays.toString(arr));
    PancakeSort.pancakeSort(arr);
    // System.out.println(Arrays.toString(arr));
  }
}
