package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Find duplicates for both array
*/
public class FindDuplicates {
  // O(M+N)
  static int[] findDuplicates(int[] arr1, int[] arr2) {
    int i = 0;
    int j = 0;

    List<Integer> res = new ArrayList<>();
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] == arr2[j]) {
        res.add(arr1[i]);
        i++;
        j++;
      } else if (arr1[i] < arr2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return res.stream().mapToInt(c -> c).toArray();
  }

  /* O(nlogn) */
    static int[] findDuplicate2(int[] arr1, int[] arr2) {
        List<Integer> res = new ArrayList<>();
        for(int a: arr1){
            if(Arrays.binarySearch(arr2,a) >= 0)
                res.add(a);
        }

        return res.stream().mapToInt(c -> c).toArray();
    }

  public static void main(String[] args) {
    //
    System.out.println(
        Arrays.toString(
            FindDuplicates.findDuplicate2(
                new int[] {1, 2, 3, 5, 6, 7}, new int[] {3, 6, 7, 8, 20})));
  }
}
