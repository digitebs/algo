package array;

import java.util.Arrays;

/**
 * Created by johnlim on 10/2/16.
 */
public class ArrayRotate {

    // using in place swwap
    public void rotate(int[] nums, int k) {
        while( --k >= 0){
            for(int i = nums.length - 1; i > 0; i--){
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp; // we shift 1 in place by swap;
            }
        }
    }

    // in place but linear time by immediatly jumping to the target
    public void rotateInPlace(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // rotate by reversal
    public void rotateReverse(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // rotate with additional array
    public void rotate3(int[] A, int K){
        int[] r = new int[A.length];
        for(int i =0; i < A.length ; i++){
            r[(i+K)%A.length] = A[i];
        }
         System.out.println(Arrays.toString(r));

    }

    public static void main(String args[]){

        ArrayRotate t = new ArrayRotate();
        int[] arr = new int[]{1,2,3,4,5,6,7};
       t.rotateInPlace(arr,4);
       System.out.println(Arrays.toString(arr));
        int[] arr2 = new int[]{1,2,3,4,5,6,7};
        t.rotate3(arr2,4);
    }
}
