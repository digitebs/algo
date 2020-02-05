package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TripletSum {

  static int binary(List<Integer> list, int l, int r, int sum) {
    // 5 - 0
    // 2
    // 30 25 20 15 10 5
    // 5 - 2 == 3/2 = 1
    if (r >= l) {
      int mid = l + (r - l) / 2;
      // System.out.println(list.get(mid) +" "+ mid +" "+ r + " "+l);
      if (mid == 0 || sum <= list.get(mid - 1) && list.get(mid) < sum) return mid; // got it
      // if(sum >= list.get(mid-1) && list.get(mid) >= sum )
      // return mid; // got it
      if (list.get(mid) < sum) {
        return binary(list, l, mid - 1, sum);
      }
      return binary(list, mid + 1, r, sum);
    }
    return r + 1;
  }

  static int triplet2(List<Integer> list, int r) {
    Collections.sort(list, (a, b) -> b - a); // n(log(n))
    int count = 0, n = list.size();
    for (int i = 0; i < n - 2; i++) { // n
      // if(list.get(i) >= r) continue; // skip
      int left = i + 1, right = n - 1;
      while (left < right) {
        if (list.get(i) + list.get(left) + list.get(right) < r) {
          count += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    return count;
  }

  static int triplet(int[] arr, int r) {
    int count = 0, n = arr.length;
    Arrays.sort(arr);
    for (int i = 0; i < n - 2; i++) { // n
      int left = i + 1, right = n - 1;
      while (left < right) {
        if (arr[left] + arr[right] + arr[i] < r) {
          count += right - left;
          left++;
        } else right--;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // System.out.println(triplet(Arrays.asList(3),25));
    //  System.out.println(binary(Arrays.asList(2,4,5,10,13,16),0, 5,15));
    //  System.out.println(binary(Arrays.asList(16,13,10,5,4,2),0, 5,13));
    System.out.println(triplet(new int[] {1, 2, 3, 7}, 11));
    // System.out.println(triplet(Arrays.asList(1,3,7),11));
    //  System.out.println(triplet(Arrays.asList(1,6,8),16));
    //  System.out.println(binary(Arrays.asList(12,11,6,5,3,1),0, 5,2));
    // System.out.println(triplet(Arrays.asList(12,11,6,5,3,1),15));
  }
}
