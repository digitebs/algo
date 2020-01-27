package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearSumDuplicateArray {


    // the trick is to update the array index linearly
    static public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> arr = new ArrayList<>(a);
        ArrayList<Integer> res = new ArrayList<>();
        long sum = ((long)arr.size() * (1 + arr.size()))/2;
        long sumArr=0;

        for(int i =0,val = Math.abs(arr.get(i))- 1;i < arr.size(); i++){
            sumArr+=val+1;
            if(arr.get(val) >= 0) arr.set(val, -arr.get(val));
            else res.add(Math.abs(arr.get(i)));
        }
        res.add((int)(sum - (sumArr-res.get(0))));
        return res;
    }

    // negating the position, if that position is seen again mean its negative
    // since the array refers to itself only
    // works only on consecutive array from 1 - n
    static public void findDuplicates(int[] arr){
        for(int i =0; i < arr.length; i++){
            int val = Math.abs(arr[i]);
            if(arr[val] >= 0) arr[val] = -arr[val];
            else System.out.println(val);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void main(String[] args) {
        findDuplicates(new int[]{3,1,6,4,5,4,3});
    }
}
