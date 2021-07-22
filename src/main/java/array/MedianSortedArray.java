package array;

import java.nio.CharBuffer;
import java.util.ArrayList;

public class MedianSortedArray {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    ArrayList<Integer> arr = new ArrayList<>();
    int j = 0, i = 0, m = nums1.length, n = nums2.length;
    while (i < nums1.length || j < nums2.length) {
      arr.add(
          (i == m ? Integer.MAX_VALUE : nums1[i]) <= (j == n ? Integer.MAX_VALUE : nums2[j])
              ? nums1[i++]
              : nums2[j++]);
    }
    int p = (m + n) / 2;
    return (n % 2 == 0) ? (arr.get(p - 1) + arr.get(p)) / 2.0 : arr.get(p);
  }
}
