package search;

/*
   right can be n-1( using mid-1) or n (using mid) as range

   if right is n-1 exit loop is <= else <

   works only on non duplcates
*/
public class BinarySearchPivot {

  /** Shifted Array Search find the pivot using binary search */
  static int pivot(int[] arr) {
    int left = 0;
    int n = arr.length - 1;
    int right = n;
    int mid = (left + right) / 2;
    while (left <= right) {
      //   System.out.println(arr[mid-1] +" "+arr[mid] +" "+arr[mid+1] );
      if (mid == n || arr[mid] > arr[mid + 1]) {
        return mid;
      } else if (arr[left] > arr[mid]) {
        // System.out.println("to the left");
        right = mid - 1;
      } else {
        // System.out.println("to the right");
        left = mid + 1;
      }
      mid = (left + right) / 2;
    }
    return -1;
  }

  public static void main(String[] args) {
    // Arrays.binarySearch()
    System.out.println(pivot(new int[] {6, 1, 2, 3, 4, 5}));
    System.out.println(pivot(new int[] {1, 2, 3, 4, 5}));
    System.out.println(pivot(new int[] {3, 4, 5, 1, 2}));
    System.out.println(pivot(new int[] {9, 12, 17, 2, 4, 5}));
  }
}
