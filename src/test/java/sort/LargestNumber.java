package sort;

import java.util.*;

public class LargestNumber {
  static String largestNumber(final List<Integer> a) {
    StringBuilder res = new StringBuilder();
    ArrayList<Integer> b = new ArrayList<>(a);

    Collections.sort(
        a,
        (o1, o2) -> {
          String str1 = String.valueOf(o1);
          String str2 = String.valueOf(o2);
          return (str1 + str2).compareTo(str2 + str1);
        });

    for (int i = a.size() - 1; i >= 0; i--) {
      res.append(a.get(i));
    }
    if (res.toString().matches("0+")) {
      return new String("0");
    }
    return res.toString();
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(Arrays.asList(3, 305, 340, 0, 98, 9890, 3139, 5, 9)));
    System.out.println(
        largestNumber(Arrays.asList(472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412)));

    System.out.println(largestNumber(Arrays.asList(12, 123)));
    System.out.println(largestNumber(Arrays.asList(12, 121)));
    System.out.println(largestNumber(Arrays.asList(8, 89)));
    System.out.println(largestNumber(Arrays.asList(3, 30)));
    System.out.println(largestNumber(Arrays.asList(0, 0, 0, 0, 1)));
  }
}
