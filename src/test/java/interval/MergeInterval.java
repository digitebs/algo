package interval;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeInterval {
  // merge non overlapping intervals
  static int mergeInterval(List<List<Integer>> list) {
    Collections.sort(
        list,
        (o1, o2) -> {
          return o1.get(0) - o2.get(0);
        });

    for (int i = 0; i < list.size() - 1; i++) {
      List<Integer> curr = list.get(i);
      List<Integer> next = list.get(i + 1);
      if (curr.get(1) >= next.get(0)) {
        curr.set(1, Math.max(next.get(1), curr.get(1)));
        list.remove(i + 1);
        i--;
      }
    }

    System.out.println(list);
    return list.size();
  }

  /*
   not efficent must use 2 pointer
  */
  static int mergeInterval(List<List<Integer>> a, List<List<Integer>> b) {
    a.addAll(b);
    return mergeInterval(a);
  }

  static List<List<Integer>> mergeInterval2(List<List<Integer>> a, List<List<Integer>> b) {

    int i = 0;
    int j = 0;
    int n = a.size();
    int m = b.size();

    List<List<Integer>> res = new ArrayList<>();

    while (i < n && j < m) {
      System.out.println(res);
      if (a.get(i).get(0) < b.get(j).get(0)) {
        if (a.get(i).get(1) > b.get(j).get(0)) {
          // merge
          res.add(
              Arrays.asList(
                  Math.min(a.get(i).get(0), b.get(j).get(0)),
                  Math.max(a.get(i).get(1), b.get(j).get(1))));
          j++;
        } else {
          if(res.size()==0 || Math.min(a.get(i).get(0), b.get(j).get(0))!= res.get(res.size()-1).get(0))
          res.add(Arrays.asList(a.get(i).get(0), a.get(i).get(1)));
          i++;
        }

      } else {
        if (b.get(j).get(1) > a.get(i).get(0)) {

          res.add(
              Arrays.asList(
                  Math.min(a.get(i).get(0), b.get(j).get(0)),
                  Math.max(a.get(i).get(1), b.get(j).get(1))));
          i++;
        } else {
          if(res.size()==0 || Math.min(a.get(i).get(0), b.get(j).get(0))!= res.get(res.size()-1).get(0))
          res.add(Arrays.asList(b.get(j).get(0), b.get(j).get(1)));
          j++;
        }
      }
    }


    while(i < n){
      res.add(a.get(i++));
    }

    while(j < m){
      res.add(b.get(j++));
    }

    return res;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(1, 2));
    list.add(Arrays.asList(1, 8));
    list.add(Arrays.asList(1, 4));
    list.add(Arrays.asList(4, 5));
    list.add(Arrays.asList(6, 8));
    System.out.println(mergeInterval(list));

    List<List<Integer>> lista = new ArrayList<>();
    lista.add(Arrays.asList(1, 2));
    lista.add(Arrays.asList(3, 4));
    lista.add(Arrays.asList(5, 7));
    lista.add(Arrays.asList(11, 12));

    List<List<Integer>> listb = new ArrayList<>();
    listb.add(Arrays.asList(5, 7));
    listb.add(Arrays.asList(8, 9));
    System.out.println("2:"+ mergeInterval2(lista, listb));


    // [[1, 5], [6, 8]]
  }
}
