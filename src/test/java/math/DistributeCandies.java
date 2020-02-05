package math;

import java.util.HashMap;

/*
Given an integer array with even length, where different numbers in this array represent different kinds of candies.
 Each number means one candy of the corresponding kind.
  You need to distribute these candies EQUALLY in number to brother and sister.
 Return the MAXIMUM number of KINDS of candies the sister could gain.
 */
public class DistributeCandies {
  public static int distributeCandies(int[] candies) {
    int n = candies.length;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < n; i++) {
      hm.put(candies[i], hm.getOrDefault(candies[i], 0) + 1);
      // if(candies[i]%2 == 0) count +=2;
      // else count ++;
    }
    return Math.min(hm.size(), n / 2);
  }

  public static void main(String[] args) {
    System.out.println(distributeCandies(new int[] {1, 1, 2, 3}));
  }
}
