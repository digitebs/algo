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

    public void rotateArray(int[] arr,int k){
        int[] result= new int[arr.length];
        for(int i=0;i < arr.length;i++){

            int newIndex = i-k;
            if(newIndex < 0){
                newIndex=(arr.length)+ (i -k);
            }

            result[newIndex]=arr[i]; //copy the values
        }

        //arr = result;
        for(int i =0;i< result.length;i++){
            System.out.println(result[i]);
        }


    }

    public void rotate3(int[] A, int K){
        int[] r = new int[A.length];
        for(int i =0; i < A.length ; i++){
            r[(i+K)%A.length] = A[i];
        }
        for(int i =0;i< r.length;i++){
            System.out.println(r[i]);
        }


    }

    public static void main(String args[]){

        ArrayRotate t = new ArrayRotate();
        int[] arr = new int[]{1,2,3,4,5,6,7};
       t.rotateArray(arr,4);
    }
}
