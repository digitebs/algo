package array;

public class LeftEqRightArray {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num; // sum it up
        for(int i = 0, left = 0; i < nums.length; i ++,left += nums[i-1]) if(sum - nums[i] - left == left) return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LeftEqRightArray().pivotIndex(new int[]{1,7,3,6,5,6}));
    }
}
