package array;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;

/*
  only works on sort array
 */
public class ArrayRemoveDuplicates {
  public int removeDuplicates(ArrayList<Integer> a) {
    int k = 0;
    boolean seen = false;
    for (int i = 1; i < a.size(); i++) {
      if (a.get(k).equals(a.get(i))) {
      /*  if (!seen) {
          seen = true;
          a.set(++k, a.get(i));
        }*/
      } else {
        a.set(++k, a.get(i));
      }
    }
    return k + 1;
  }

  public static final void swap(int[] a, int i, int j) {
    a[i] = a[i] ^ a[j];
    a[j] = a[i] ^ a[j];
    a[i] = a[i] ^ a[j];
  }

  public int removeDuplicates(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[j] != nums[i + 1]) {
        swap(nums, ++j, i + 1);
      }
    }
    // System.out.println(Arrays.toString(nums));
    return j + 1;
  }

  public static void main(String args[]) {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(1000);
    a.add(1000);
    a.add(1000); // k
    a.add(1000); // k=2
    a.add(1001); // i
    a.add(1002); // i
    a.add(1003);
    a.add(1003);
    a.add(1004);
    a.add(1005);
    out.println(new ArrayRemoveDuplicates().removeDuplicates(a));
    out.println(Arrays.toString(a.toArray()));
    /*
    System.out.println(removeDuplicates(new int[] {1}));
    System.out.println(removeDuplicates(new int[] {1, 1, 2, 2}));
    System.out.println(removeDuplicates(new int[] {1, 1, 2, 3, 3, 4, 350, 351}));
    */
  }
}
