package sort;

import java.util.ArrayList;
import java.util.List;

/** find longest contigous path that intersect */
public class ClickStreamPath {
  static List<String> getlen(String[] a, String b[], int i, int j) {
    List<String> arr = new ArrayList<>();
    while (i < a.length && j < b.length && a[i].equals(b[j])) {
      arr.add(a[i]);
      i++;
      j++;
    }
    return arr;
  }

  static List<String> test(String[] user0, String[] user1) {
    List<String> max = new ArrayList<>();
    for (int i = 0; i < user0.length; i++) {
      for (int j = 0; j < user1.length; j++) {
        if (user0[i].equals(user1[j])) {
          List<String> res = getlen(user0, user1, i, j);
          if (res.size() > max.size()) {
            max = res;
          }
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    String[] user0 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
    String[] user1 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
    String[] user2 = {"a", "/one", "/two"};
    String[] user3 = {
      "/red",
      "/orange",
      "/yellow",
      "/green",
      "/blue",
      "/purple",
      "/white",
      "/amber",
      "/HotRodPink",
      "/BritishRacingGreen"
    };
    String[] user4 = {
      "/red",
      "/orange",
      "/amber",
      "/random",
      "/green",
      "/blue",
      "/purple",
      "/white",
      "/lavender",
      "/HotRodPink",
      "/BritishRacingGreen"
    };
    String[] user5 = {"a"};

    System.out.println(test(user0, user1));
  }
}
