package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class TopKFrequentElement {

  public List<Integer> topKFrequent(int[] nums, int k) {
    int n = nums.length;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
    }

    HashMap<Integer, List> hm2 = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List temp = hm2.getOrDefault(hm.get(nums[i]), new ArrayList<>());
      hm2.put(hm.get(nums[i]),temp);
      temp.add(nums[i]);
      //System.out.println(hm2.get(nums[i]));
    }

    //System.out.println(hm2);
    List<Integer> res = new ArrayList<>();
    outer:
    for (int i = n; i > 0; i--) {
      List<Integer> temp;
      if ((temp = hm2.get(i)) != null) {
        for (int v : temp) {
          res.add(v);
          k--;
          if (k == 0) break outer;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    TopKFrequentElement tke = new TopKFrequentElement();
    System.out.println(tke.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
  }
}
