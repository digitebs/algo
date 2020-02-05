package array;

import java.util.Arrays;

/** n^2 max */
public class ThreeSumsArray {
  void sum(int[] arr, int target) {
    Arrays.sort(arr); // nlogn
    for (int i = 0; i < arr.length; i++) { // n * n == n^2
      int j = i, k = arr.length - 1;
      // using 2 pointer
      while (j != k) { // collapse it in
        int sum = arr[i] + arr[j] + arr[k];
        if (sum > target) k--; // we move backward
        else if (sum < target) j++;
        else if (sum == target) {
          System.out.printf("%d,%d,%d", i, j, k);
          break;
        }
      }
    }
  }

  void sum2(int[] arr, int target) {
    Arrays.sort(arr); // nlogn
    for (int i = 0; i < arr.length; i++) { // n * n == n^2
      int j = i + 1, k = arr.length - 1;
      while (j < k) { // collapse it in
        int sum = arr[i] + arr[j] + arr[k];
        if (sum > target) k--; // we move backward
        else if (sum < target) j++;
        else if (sum == target) {
          System.out.printf("%d,%d,%d\n", i, j, k);
          i++;
          k--;
          // break;
        }
      }
    }
  }

  // print sum with unique index O(n3)
  static void sumIndex(int[] arr, int target) {
    Arrays.sort(arr); // nlogn
    for (int i = 0; i < arr.length; i++) { // n * n == n^2
      int j = i + 1, k = arr.length - 1;
      while (j < k) { // collapse it in
        int sum = arr[i] + arr[j] + arr[k];
        if (sum > target) k--; // we move backward
        else if (sum < target) j++;
        else if (sum == target) {
          System.out.printf("%d,%d,%d\n", i, j, k);
          for (int l = k; j < l - 1 && arr[l] == arr[l - 1]; l--) {
            System.out.printf("%d,%d,%d\n", i, j, l - 1);
          }
          j++;
        }
      }
    }
  }

  public static void main(String[] args) {
    new ThreeSumsArray().sum(new int[] {2, 7, 11, 15}, 24);
  }
}
