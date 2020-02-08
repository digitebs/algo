package search;

import java.util.Arrays;
import java.util.List;

public class SmallestLargestNumber {
  /*
     find the smallest number that is greater than the target,

     binary search that uses only 1 condition
  */
  static int binarySearch(List<Integer> arr, int target) {
    int left = 0;
    int right = arr.size();


    // 5 9 11 12 13 14 20 25
    while (left < right) {
        int mid = (left + right) / 2;
        if (target >= arr.get(mid)) {
          left = mid+1;
      } else {
          right = mid;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    //
    List list = Arrays.asList(5, 9, 11, 12, 13, 14, 20, 25);
    System.out.println(SmallestLargestNumber.binarySearch(list,10));
  }
}
