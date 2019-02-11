package sort;

import java.util.Arrays;

public class MissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min=1;
        for(int i= 0; i < nums.length; i++){
            if(nums[i] >= 1){
                if(i!=0 && nums[i]==nums[i-1]);
                else if(min == nums[i]) min++;
                else break;
            }
        }
        return min;
    }
}
