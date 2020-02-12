package math;

import scala.collection.mutable.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPermutation {
  static char[] swap(char[] arr, int i, int j) {
    char t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
    return arr;
  }

  static List<String> res = new ArrayList<>();

  static void combine(char[] arr, int k) {
    // hs.add(new String(arr));
    if (k == arr.length) res.add(new String(arr));
    for (int i = k; i < arr.length; i++) {
      swap(arr, k, i);
      combine(arr, k + 1);
      swap(arr, k, i);
    }
  }

  public static void main(String args[]) {
    char[] arr = new char[] {'c', 'd', 'h', 'k'};
    combine(arr, 0);
    System.out.println(res);
  }
}
