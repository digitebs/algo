package array;


/*

conveyour belt
 find which ith belt where the luggage total from left of i and the total from the right of i is the same, find the i
 , return -1 if not found

  Given, an array of size n. Find an element which divides the array in two sub-arrays with equal sum

  return the index
 */
public class LeftEqRightArray {
  public int pivotIndex(int[] nums) {
    int sum = 0;
    for (int num : nums) sum += num; // sum it up
    for (int i = 0, left = 0; i < nums.length; i++, left += nums[i - 1])
      if (sum - nums[i] - left == left) return i;
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(new LeftEqRightArray().pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
    System.out.println(new LeftEqRightArray().pivotIndex(new int[] {1}));
    System.out.println(new LeftEqRightArray().pivotIndex(new int[] {1,2}));
    System.out.println(new LeftEqRightArray().pivotIndex(new int[] {2,1,1,1}));
    System.out.println(new LeftEqRightArray().pivotIndex(new int[] {1,4,2,5}));
  }
}
