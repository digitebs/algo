package search;

import java.util.Arrays;

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

  // binary array 1 and 0 only sorted
  public static int pivot4(int[] arr) {
    int m = arr.length;
    int l = 0;
    int r = m-1;
    int mid = l + (r-l) / 2;

    while(l <= r){
      int a = arr[mid];
      if(a == 1) r = mid-1;
      else l = mid+1;

      mid = l + (r-l) / 2;
    }
    return l;
/*
    while (l <= r) {
      int b = arr[mid];
      int a = arr[mid+1];
      if (b < a) {
        return mid + 1;
      } else if (mid == 0 && b == 1) {
        return mid;
      } else if (a == 0 && b == 0) l = mid + 1;
      else r = mid - 1;
      mid = (l + r) / 2;
    }
    return -1;*/
}

  public static int pivot3(int[] arr) {

    // find the rotation point in the array
    // pivot is mid-1 > && mid < mid +1
    // start > mid
    // move left
    // move right
    // 2 3 4 5 1
    // 3 4 5 6 7 1 2
    // 4 5 6 7 1 2 3
    //6 7 1 2 3 4 5
    // 3 4 5 6 7 1 2

    int left = 0;
    int right = arr.length;
    //if(arr[right] > arr[left]) return 0;//  force???
    while (left + 1 < right) {
      int mid = left +(right-left) / 2; // forces no overflow
     // System.out.println("mid"+mid);
      if (arr[0] >= arr[mid] ) {
        right = mid;
      } else {
        left = mid;
      }
      //if(left +1 == right) break;

    }
    return right;
  }

  public static void main(String[] args) {


    /*
    2
0
0
7
8
3
3
4

     */
    // Arrays.binarySearch()
    System.out.println(pivot3(new int[] {1,2}));
    System.out.println(pivot3(new int[] {3,1}));
    System.out.println(pivot3(new int[] {8, 1, 2, 3, 4, 5,6,7}));
    System.out.println(pivot3(new int[] {2, 3, 4, 5,6,7,8,1}));
    System.out.println(pivot3(new int[] {1, 2, 3, 4, 5,6,7,8}));
    System.out.println(pivot3(new int[] {3, 4, 5, 1, 2}));
    System.out.println(pivot3(new int[] {9, 12, 17, 2, 4, 5}));
    System.out.println(pivot3(new int[] {4,5,6,7,0,1,2}));



//    System.out.println(pivot4(new int[] {0,0,0,1}));
//    System.out.println(pivot4(new int[] {0,0,1,1}));
//    System.out.println(pivot4(new int[] {1,1,1,1}));
//    System.out.println(pivot4(new int[] {0,0,0,0}));


  }
}
