package interval;

import java.util.*;

public class MergeInterval {
  // merge non overlapping intervals
  static int mergeInterval(List<List<Integer>> list) {
    Collections.sort(
        list,
        (o1, o2) -> {
          return o1.get(0) - o2.get(0);
        });

    for(int i = 0; i < list.size()-1;i++){
      List<Integer> curr = list.get(i);
      List<Integer> next = list.get(i+1);
      if (curr.get(1) >= next.get(0)) {
        curr.set(1, Math.max(next.get(1),curr.get(1)));
        list.remove(i+1);
        i--;
      }
    }

    System.out.println(list);
    return list.size();
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(1, 2));
    list.add(Arrays.asList(1, 8));
    list.add(Arrays.asList(1, 4));
    list.add(Arrays.asList(4, 5));
    list.add(Arrays.asList(6, 8));
    System.out.println(mergeInterval(list));

    // [[1, 5], [6, 8]]
  }
}
