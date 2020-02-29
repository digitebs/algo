package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*

medium*

You are given an array and you need to find number of tripets of indices
  such that the elements at those indices are in geometric progression for a given common ratio r and i <j <k .

{1,4,16,64} r = 4
{1,4,16}
{4,16,64}

2

 */
public class CountTriplets {

  // interesting problem to study using {{HashMap}} progression using 2 maps. assigning the next val
  // to the next, adding increment
  // of previous one
  private static long countTriplets(List<Long> arr, long r) {
    HashMap<Long, Long> h = new HashMap<>();
    HashMap<Long, Long> m = new HashMap<>();
    // map
    long res = 0;
    for (Long a : arr) {
      res += h.getOrDefault(a, 0L);
      h.put(a * r, h.getOrDefault(a * r, 0L) + m.getOrDefault(a, 0L));
      m.put(a * r, m.getOrDefault(a * r, 0L) + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(countTriplets(Arrays.asList(5L, 10L, 20L), 2));
  }
}
