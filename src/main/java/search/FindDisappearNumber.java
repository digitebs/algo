package search;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.
 */
public class FindDisappearNumber {
  /*
     using chainning swap (NUTS)

     works only on element that fits in the array
  */
  public List<Integer> findDisappearedNumbers(int[] nums) {
    int p = 0;
    while (p < nums.length) {
      int temp = nums[p];
      if (temp - 1 != p && temp != nums[temp - 1]) {
        nums[p] = nums[temp - 1];
        nums[temp - 1] = temp;
      } else {
        p++;
      }
    }
    List<Integer> rs = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i + 1 != nums[i]) rs.add(i + 1);
    }
    return rs;
  }

  public static void main(String[] args) {
    System.out.println(
        new FindDisappearNumber().findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
  }
}
