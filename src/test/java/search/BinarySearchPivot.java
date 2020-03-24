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
    int n = arr.length;
    int right = n;
    int mid = (left + right) / 2;
    while (left < right) {
      //   System.out.println(arr[mid-1] +" "+arr[mid] +" "+arr[mid+1] );
      if (mid + 1 == right || arr[mid] > arr[mid + 1]) {
        return mid;
      } else if (arr[left] > arr[mid]) {
        // System.out.println("to the left");
        right = mid;
      } else {
        // System.out.println("to the right");
        left = mid;
      }
      mid = (left + right) / 2;
    }
    return -1;
  }

  /*
    this pivot on smallest
   */
  static int pivot2(int[] arr) {
    int left = 0;
    int n = arr.length;
    int right = n;
    int mid = (left + right) / 2;
    while (left < right) {
       //System.out.println(left+" "+mid+" "+right );
      // if(mid == left) return left;
       if (mid-1 < left || arr[mid-1] > arr[mid]) {
        return mid;
      } else if (arr[right-1] >= arr[mid]) {
         //tricky!!! because right-1 can equal to mid itslef
         // when element is < 2
         // example: 0 1
         // mid will be 1 because 2/2 == 1
        right = mid;
      } else {
        left = mid;
      }
      mid = (left + right) / 2;
    }
    return left;
  }

  public static void main(String[] args) {
    // Arrays.binarySearch()
    System.out.println(pivot2(new int[] {8, 1, 2, 3, 4, 5,6,7}));
    System.out.println(pivot2(new int[] {2, 3, 4, 5,6,7,8,1}));
    System.out.println(pivot2(new int[] {1, 2, 3, 4, 5,6,7,8}));
    System.out.println(pivot2(new int[] {3, 4, 5, 1, 2}));
    System.out.println(pivot2(new int[] {9, 12, 17, 2, 4, 5}));
  }
}
