package array;

public class LargestTwiceArray {
    public int largestTwice(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) if (nums[index] < nums[i]) index = i;
        for (int i = 0; i < nums.length; i++) if (nums[i] * 2 > nums[index] && i != index) return -1;
        return index;
        
    }

    public static void main(String[] args) {
        System.out.println(new LargestTwiceArray().largestTwice(new int[]{3, 6, 1, 0}));
    }
}
