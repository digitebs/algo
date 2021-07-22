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

  static int binarySearch2(int target) {
    int left = 0;
    int right = target;

    // 5 9 11 12 13 14 20 25
    while (left +1< right) {
      int mid = (left + right) / 2;
      if (target < mid*mid) {
        right = mid;
      } else {
        left = mid;
      }
      //  System.out.println(right+ " "+mid+" "+left);
    }
    return left;
  }

  public int mySqrt(int x) {
    if (x <= 1) return x;
    List<Long> nums = new ArrayList<>();
    long num = 1;
    while (num * num <= x) { // sqrt
      nums.add(num++);
    }
    return (int)num-1;
  //  return nums.get(binarySearch(nums, x)).intValue();
  }

  // epsillon
  double binarySearch(double target) {
    double lo = 0;
    double hi = target;
    double eps = 0.001;

    // 5 9 11 12 13 14 20 25
    while (lo < hi) {
      double mid = ( hi + lo) / 2.0;
      double num = mid*mid;
      //System.out.println(hi +" "+lo+" "+ mid);
      if (target - num >= 0 && target - num <= eps) {
          return mid;
      }else if(num > target){
        hi = mid;
      } else {
        lo = mid;
      }
      //  System.out.println(right+ " "+mid+" "+left);
    }
    return -1;
  }
  public static void main(String[] args) {
    Sqrt sq = new Sqrt();
    //System.out.println(sq.mySqrt(5));
    //System.out.println(sq.binarySearch2(16));
    System.out.println(sq.binarySearch(9));
  }
}
