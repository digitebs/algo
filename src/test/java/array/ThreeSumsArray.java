package array;

import java.util.Arrays;


/*

// given an array and integer, find all unique possible 3 numbers  in the array thats sum to that integer


Input:
{2, 7, 11, 15, 11},  24

Output:
// print
2, 7, 15
2, 11, 11




 */
// // given an array an integer, find all 3 numbers  in the array thats sum to that integer
/** n^2 max */
public class ThreeSumsArray {

  // solution with duplicates
  void sum(int[] nums, int target) {
    Arrays.sort(nums); // nlogn
    for (int i = 0; i < nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;

  ////    if (i > 0 && nums[i] == nums[i - 1]) {
    //    continue;
     // }

      while (j < k) {
       // if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
         // k--;
          //continue;
        //}

        if (nums[i] + nums[j] + nums[k] > target) {
          k--;
        } else if (nums[i] + nums[j] + nums[k] < target) {
          j++;
        } else {
          System.out.printf("%d,%d,%d\n", nums[i], nums[j], k);
          j++;
          k--;
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
    //new ThreeSumsArray().sum(new int[] {2, 7, 11, 15, 11}, 24);
    new ThreeSumsArray().sum(new int[] {1,1,1,2,2}, 3);
  }
}
