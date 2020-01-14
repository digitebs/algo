package array;

import java.util.Arrays;

/**
 * @author john.lim
 *
 *
 * sort colors rgb(0,1,2)
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {


    /*
        using in place constant space
     */
    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i <= end;){
            if(nums[i] == 0){
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            }else if(nums[i] == 2){
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            }else i++;
        }
    }
    public static void main(String[] args) {
        int[] n = new int[]{2,0,2,1,1,0};
        sortColors(n);
        System.out.println(Arrays.toString(n));
    }
}
