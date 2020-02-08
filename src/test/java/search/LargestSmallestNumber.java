package search;

import java.util.Arrays;
import java.util.List;

public class LargestSmallestNumber {
  /*
     find the largest number that is less than the target
  */
  static int binarySearch(List<Integer> arr, int target) {
    int left = 0;
    int right = arr.size();
    int mid = (left + right) / 2;
    // 5 9 11 12 13 14 20 25
    while (left < right) {
      // System.out.println(left + " " + right + " " + mid);
      if (right - left <= 1 && arr.get(mid) <= target) {
        return mid;
      } else if (target <= arr.get(mid)) {
        right = mid;
      } else {
        left = mid;
      }
      mid = (left + right) / 2;
    }
    return -1;
  }

  public static void main(String[] args) {
    //
    List list = Arrays.asList(5, 9, 11, 12, 13, 14, 20, 25);
    System.out.println(LargestSmallestNumber.binarySearch(list, 1));
  }
}
