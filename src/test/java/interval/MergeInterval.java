package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeInterval {
  // merge non overlapping intervals
  static int mergeInterval(List<List<Integer>> list) {
    Collections.sort(
        list,
        (o1, o2) -> {
          int diff = o1.get(0) - o2.get(0);
          return diff;
        });

    for (int i = list.size() - 1; i > 0; i--) {
      if (list.get(i - 1).get(1) >= list.get(i).get(0)) {
        list.get(i - 1).set(1, list.get(i).get(1));
        list.remove(i); // remove this;
      }
    }

    System.out.println(list);
    return list.size();
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(1, 2));
    list.add(Arrays.asList(1, 3));
    list.add(Arrays.asList(1, 4));
    list.add(Arrays.asList(4, 5));
    list.add(Arrays.asList(6, 8));
    System.out.println(mergeInterval(list));

    // [[1, 5], [6, 8]]
  }
}
