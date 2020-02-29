package sort;

import java.util.Arrays;

/*

Easy* good sorting algo problem

Some people are standing in a row in a park.
 There are trees between them which cannot be moved.
  Your task is to rearrange the people by their heights in a ascending order without moving the trees.
   People can be very tall!
 */
public class SortWithTree {

  int[] sortByHeight(int[] arr) {
    // section sort???
    int[] arr2 = Arrays.copyOf(arr, arr.length);
    Arrays.sort(arr2);
    int j = arr2.length - 1, i = arr.length - 1;
    while (i >= 0) {
      if (arr[i] != -1) {
        arr[i] = arr2[j--];
      }
      i--;
    }
    return arr;
  }

  public void baloonSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] != -1 && arr[i] > arr[j]) {
          arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
        }
      }
    }
  }

  public static void main(String[] args) {
    //
    SortWithTree swt = new SortWithTree();
    int[] arr = new int[] {-1, 150, 190, 170, -1, -1, 160, 180};
    swt.baloonSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
