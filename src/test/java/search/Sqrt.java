package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Sqrt {
  static int binarySearch(List<Long> arr, int target) {
    int left = 0;
    int right = arr.size();

    // 5 9 11 12 13 14 20 25
    while (left < right) {
      int mid = (left + right) / 2;
      if (target == arr.get(mid)*arr.get(mid)) {
        return mid;
      }else if (target < arr.get(mid)*arr.get(mid)) {
        right = mid -1;
      } else {
        left = mid + 1;
      }
      //  System.out.println(right+ " "+mid+" "+left);
    }
    return left - 1;
  }

  public int mySqrt(int x) {
    if (x <= 1) return x;
    List<Long> nums = new ArrayList<>();
    long num = 1;
    while (num * num <= x) {
      nums.add(num++);
    }
    return nums.get(binarySearch(nums, x)).intValue();
  }
}
