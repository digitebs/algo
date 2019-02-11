package array;

import java.util.Arrays;

public class LargestPermutationArray {
    static int[] largestPermutation(int k, int[] arr) {
        int n = arr.length;
        int[]pos = new int[arr.length+1];
        for(int i = 0 ; i < arr.length; i++)
            pos[arr[i]] = i;

        for(int i = 0; i < n && k >0; i++){
            if(arr[i]  == n -i)
                continue;
            int temp= pos[n-i];
            pos[arr[i]] = pos[n-i];
            pos[n-i] = i;
            //swap the highest position to the first element;
            int tmp1= arr[temp];
            arr[temp] = arr[i];
            arr[i] = tmp1;

            --k;
        }
        return arr;

    }

    public static void main(String[] args) {
        long a = ((long)100000 * (1 + 100000))/2;
        System.out.println(a);
       //System.out.println(Arrays.toString(largestPermutation(1, new int[]{1,2,3})));
    }
}
