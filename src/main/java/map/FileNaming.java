package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

   medium* don't use due to analysis of problem

  You are given an array of desired filenames in the order of their creation.
   Since two files cannot have equal names,
    the one which comes later will have an addition to its name in a form of (k),
     where k is the smallest positive integer such that the obtained name is not used yet.

     For names = ["doc", "doc", "image", "doc(1)", "doc"],
  output= ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"]
 */
public class FileNaming {
  String[] fileNaming(String[] names) {
    Map<String, Integer> hm = new HashMap<>();
    for (int i = 0; i < names.length; i++) {
      int count = hm.getOrDefault(names[i], 0);
      if (count > 0) {
        while (hm.containsKey(names[i] + "(" + count + ")")) count++;
        names[i] = names[i] + "(" + count + ")";
      }
      hm.put(names[i], hm.getOrDefault(names[i], 0) + 1);
    }
    return names;
  }

  public static void main(String[] args) {
    FileNaming fn = new FileNaming();
    System.out.println(Arrays.toString(fn.fileNaming(new String[]{
            "doc",
            "doc",
            "image",
            "doc(1)",
            "doc"
    })));
    System.out.println(Arrays.toString(fn.fileNaming(new String[]{
            "a(1)",
            "a(6)",
            "a",
            "a",
            "a",
            "a"
    })));
    System.out.println(Arrays.toString(fn.fileNaming(new String[]{
            "dd",
            "dd(1)",
            "dd(2)",
            "dd",
            "dd(1)",
            "dd(1)(2)",
            "dd(1)(1)",
            "dd",
            "dd(1)"
    })));


  }
}
