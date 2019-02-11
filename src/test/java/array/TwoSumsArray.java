package array;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 2 sums can be solve by storing the diff in the hash, or n^2 loop
 *
 */
public class TwoSumsArray {
    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.get(nums[i])==null) hm.put(target - nums[i], i);
            else return new int[]{hm.get(nums[i]),i};
        }
        return new int[]{-1,-1}; // wont happen;
    }

    public static void main(String[] args) {
            System.out.println(Arrays.toString(new TwoSumsArray().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
