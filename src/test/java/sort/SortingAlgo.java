package sort;

import java.util.*;

/** Created by johnlim on 10/2/16. */
public class SortingAlgo {

  static int[] swap(int i, int j, int[] arr) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;

    return arr;
  }

  // 15 20 1 26 23
  // 1 20 15 26 23, fixing the position not number
  // 1 15 20 26 23

  /*
  hoare
  */
  public int partition(int[] arr, int lo, int hi) {
    int pivot = arr[lo];
    int i = lo - 1;
    int j = hi + 1;
    while (true) {
      //do i++;
      while (arr[++i] < pivot);
      //do j--;
      while (arr[--j] > pivot);
      // System.out.println();
      if (i >= j) return j;
      swap(i, j, arr);
    }
  }

  /*
     lomuto
  */
  private int partition2(int arr[], int lo, int hi) {
    int pivot = arr[hi];
    int i = lo;
      // 1 2 40 50 30
    // 1 2 40 50 6 7 30
    for (int j = lo; j < hi; j++) {
      if (arr[j] <= pivot) {
        swap(i, j, arr);
        i++;
      }
    }
    swap(i, hi, arr);
    return i;
  }

  public void quicksort(int[] arr, int lo, int hi) {
    if (lo < hi) {
      int p = partition(arr, lo, hi);
      quicksort(arr, lo, p);
      quicksort(arr, p + 1, hi);
    }
  }

  public void bubbleSort(int[] arr) {

    int i = 0;
    do {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(j, j + 1, arr);
        }
      }
      i++;
    } while (i < arr.length);

    for (int k = 0; k < arr.length; k++) {
      System.out.println(arr[k]);
    }
  }

  public void baloonSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i+1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          swap(i, j, arr);
        }
      }
    }
  }

  public void selectionSort(int arr[]) {
    int minIndex = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      // findthe lowest swap to the index
      for (int j = (i + 1); j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      if (i != minIndex) swap(i, minIndex, arr);
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  // pushing the data to correct post
  static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {

        swap(j, j + 1, arr);
        System.out.println(Arrays.toString(arr));
      }
    }
  }

  static List mergeSort(List<Integer> arr) {
    if (arr.size() <= 1) return arr; // no need to break it appart
    int pivot = arr.size() / 2;
    List left = mergeSort(arr.subList(0, pivot));
    List right = mergeSort(arr.subList(pivot, arr.size()));
    return merge(left, right);
  }

  static List merge(List<Integer> left, List<Integer> right) {
    List<Integer> res = new ArrayList();
    ListIterator<Integer> l = left.listIterator();
    ListIterator<Integer> r = right.listIterator();
    while (l.hasNext() && r.hasNext()) {
      if (left.get(l.nextIndex()) <= right.get(r.nextIndex())) {
        res.add(l.next()); // append this
      } else res.add(r.next()); // append this
    }

    while (l.hasNext()) res.add(l.next());
    while (r.hasNext()) res.add(r.next());
    return res;
  }

  static int[] mergeSort(int[] arr) {
    if (arr.length <= 1) return arr; // no need to break it appart

    int pivot = arr.length / 2;
    int[] left = Arrays.copyOfRange(arr, 0, pivot);
    int[] right = Arrays.copyOfRange(arr, pivot, arr.length);

    left = mergeSort(left);
    right = mergeSort(right);
    return merge(left, right);
  }

  static int[] merge(int[] left, int[] right) {
    int[] res = new int[left.length + right.length];
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length) {
        res[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
    }
    while (i < left.length) res[k++] = left[i++];
    while (j < right.length) res[k++] = right[j++];
    return res;
  }

  public static void main(String args[]) {

    SortingAlgo t = new SortingAlgo();
    //  int[] arr=new int[]{3,7,4,9,5,2,6,1};
    // int[] arr=new int[]{3,7,4,8,5,2,6,1};
    int[] arr = new int[] {7, 5, 7, 5, 4, 3, 2, 1};
    // t.quicksort(arr,0,7);
    // for(int i =0;i< arr.length;i++){
    // System.out.print(arr[i]);
    // }
    // t.selectionSort(new int[]{3,7,4,9,5,2,6,1});
    // t.baloonSort(arr);
    //  List arr = new ArrayList(Arrays.asList(1,7,5,4,3,9));
    arr = t.mergeSort(arr);
    //t.quicksort(arr, 0, arr.length - 1);
    //insertionSort(arr);
     System.out.println(Arrays.toString(arr));
  }

}
