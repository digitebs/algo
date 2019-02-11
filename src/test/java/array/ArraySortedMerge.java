package array;

import java.util.Arrays;

public class ArraySortedMerge {

    // the trick is to start at the back to prevent swapping
    // [1,2,3,,] 5
    // [4,5] 2
    private void merge(int[] a, int[] b){
        int indexA = a.length - b.length -1;
        int indexB = b.length - 1;
        int indexMerged = a.length - 1; // the empty ones
        while(indexB >= 0){ // while still greater than zero
            a[indexMerged--] = (indexA >= 0 && a[indexA] > b[indexB])?  a[indexA--]:  b[indexB--];
        }
    }
    public static void main(String[] args) {
        ArraySortedMerge asm = new ArraySortedMerge();
        int[] a = new int[]{1,2,3,0,0};
        asm.merge(a,new int[]{4,5});
        System.out.println(Arrays.toString(a));

        a = new int[]{2,3,5,0,0};
        asm.merge(a,new int[]{1,4});
        System.out.println(Arrays.toString(a));
    }
}
