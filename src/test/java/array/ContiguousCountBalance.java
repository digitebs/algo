package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author john.lim
 */
/*
    Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
    Input: 0,1
    Output: 2

    Input: 0,0,1,0,0,0,1,1
    Ouptut: 6, == 1,0,0,0,1,1

 */
public class ContiguousCountBalance {


    // histogram the count,index
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        int count =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1); // use -1 so it adds on the edge to edge
        for(int i = 0 ; i < n; i++){
            count += (nums[i] ==0)?-1: 1; // + or -
            if(hm.containsKey(count)){
                max = Math.max(max, i - hm.get(count));
            }else hm.put(count, i); // store the index
        }
        return max;
    }


    // brute force
    public int findMaxLength2(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0 ; i < n; i++){
            int temp=nums[i];
            for(int j = i+1; j < n; j+=1){
                temp+= nums[j];
                if(temp == (j-i+1)/2. ) //check if balance
                    max = Math.max(j-i+1, max);
            }
        }

        return max;
    }

  public static void main(String[] args) {

        ContiguousCountBalance ccb = new ContiguousCountBalance();
    System.out.println(ccb.findMaxLength(new int[]{0,1}));
    System.out.println(ccb.findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
    //
  }
}
