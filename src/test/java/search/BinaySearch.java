package search;

public class BinaySearch {


    /**
     * Shifted Array Search
     * find the pivot using binary search
     *
     */
    static int pivot(int[] arr) {
        int left = 0;
        int n = arr.length-1;
        int right = n;
        int mid = (left + right)/2;
        while(left <= right){
            if(left == right) return left;
         //   System.out.println(arr[mid-1] +" "+arr[mid] +" "+arr[mid+1] );
            if(mid < right && arr[mid] > arr[mid+1]){
                return mid;
            }else if(mid > left && arr[mid] < arr[mid-1] ){
                return mid -1;
            }else if(arr[left] >= arr[mid]){
                // System.out.println("to the left");
                right = mid -1;
            }else{
                // System.out.println("to the right");
                left = mid+1;
            }
            mid = (left + right)/2;
        }
        return -1;
    }


    /*
        find the 1st found;
     */
    static int binarySearchS(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        int mid = (left + right)/2;
        while(left <= right){
            if((mid > left && arr[mid]!= arr[mid-1] && target == arr[mid]) ||
                    (mid == left  && target == arr[mid])){
                return mid;
            }else if(target == arr[mid] || target < arr[mid] ){
                right = mid -1;
            }else{
                left = mid +1;
            }
            mid = (left + right)/2;
        }
        return -1;
    }

    /*
        find the last found;
    */
    static int binarySearchE(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        int mid = (left + right)/2;
        while(left <= right){
            if((mid < right && arr[mid]!= arr[mid+1] && target == arr[mid]) ||
                    (mid == right  && target == arr[mid])){
                return mid;
            }else if(target == arr[mid] || target > arr[mid] ){
                left = mid +1;
            }else{
                right = mid -1;
            }
            mid = (left + right)/2;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        int mid = (left + right)/2;
        while(left <= right){
            if(target == arr[mid]){
                return mid;
            }else if(target < arr[mid] ){
                right = mid -1;
            }else{
                left = mid +1;
            }
            mid = (left + right)/2;
        }
        return -1;
    }

    /*
    Given a sorted array arr of distinct integers,
    write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index.
     Analyze the time and space complexities of your solution and explain its correctness.
     */
    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here

        int left = 0;
        int right = arr.length -1;
        int mid = (left+right)/2;

        int min =-1;
        while(left <= right){
            if( arr[mid] == mid){
                min = mid;
                right = mid-1;
            }else if(arr[mid] < mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
            mid = (left+right)/2;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(pivot(new int[]{6,1,2,3,4,5}));
        System.out.println(pivot(new int[]{1,2,3,4,5,0}));
        System.out.println(pivot(new int[]{3,4,5,1,2}));
        System.out.println(pivot(new int[]{9,12,17,2,4,5}));
        // start target
        System.out.println(binarySearchS(new int[]{5,7,7,8,8,10},8));
        // end target
        System.out.println(binarySearchS(new int[]{5,7,7,8,8,10},8));
        System.out.println(indexEqualsValueSearch(new int[]{-8,0,2,5}));
        // shiftedArrSearch(new int[]{9,12,17,2,4,5},2);
    }


}
