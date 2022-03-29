package array;


/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 */
public class FindDuplicateNumber {

  // flyod turtoise hare
  public int findDuplicate(int[] nums) {

    int turtle =nums[0];
    int hare= nums[0];
    do{
      hare = nums[nums[hare]];
      turtle = nums[turtle];
    }while( hare != turtle);

    // System.out.println()
    turtle =nums[0];
    while( hare != turtle){
      hare = nums[hare];
      turtle = nums[turtle];
    }
    return hare;
  }

  public static void main(String[] args) {
    var fdn = new FindDuplicateNumber();
    System.out.println(fdn.findDuplicate(new int[]{1,3,4,2,2}));
  }
}
