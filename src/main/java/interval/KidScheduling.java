package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  Cameron and Jamie have a list of N activities to take care of during the day.

  Given the starting and ending times of each activity,
   find any schedule that does not require the same person to cover overlapping activities,
    or say that it is impossible.


 */
public class KidScheduling {


  static String schedule(List<int[]> orig) {
    int[] j ,c ; // empty;
    j = c = null; // empty

    List<int[]> lists = new ArrayList<>(orig); // clone object
    Collections.sort(lists, (a,b) -> {
      int  r = a[0] - b[0];
      if(r == 0) return a[1]-b[1];
      else return r;
    });

    Map<int[], String> hm = new HashMap<>();
   // lists.forEach(x -> System.out.println(Arrays.toString(x)));
    StringBuilder sb = new StringBuilder();
    for (int[] i : lists) {
      if (j == null || j[1] <= i[0]) {
        j = i;
        hm.put(i, "C");
        //sb.append("C"); // okay
      }
      else if (c == null || c[1] <= i[0]) {
        c = i;
        hm.put(i, "J");
       // sb.append("J"); // okay
      }
      else return "IMPOSSIBLE";
    }

    for(int[] i: orig){
      sb.append(hm.get(i)); //match using equals?
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    List<int[]> arr = new ArrayList<>();
    arr.add(new int[]{360,480});
    arr.add(new int[]{420,540});
    arr.add(new int[]{600,600});
    System.out.println(schedule(arr));

    arr = new ArrayList<>();
    arr.add(new int[]{0,1440});
    arr.add(new int[]{1,3});
    arr.add(new int[]{2,4 });
    arr.add(new int[]{5});
    System.out.println(schedule(arr));

    arr = new ArrayList<>();
    arr.add(new int[]{99,150});
    arr.add(new int[]{1,100});
    arr.add(new int[]{100,301});
    arr.add(new int[]{2,5 });
    arr.add(new int[]{150,250 });
    System.out.println(schedule(arr));
  }
}
