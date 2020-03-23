package greedy;

/*
  Input : arr = {3, 6, 1, 0}
  Output : 1
  Here, 6 is the largest integer, and for
  every other number in the array x, 6 is
  more than twice as big as x. The index of
  value 6 is 1, so we return 1.

  Input : arr = {1, 2, 3, 4}
  Output : -1
  4 isn't at least as big as twice the value
  of 3, so we return -1.
 */
public class LargestTwiceArray {
  public int largestTwice(int[] nums) {
    int index = 0;
    for (int i = 0; i < nums.length; i++) if (nums[index] < nums[i]) index = i;
    for (int i = 0; i < nums.length; i++) if (nums[i] * 2 > nums[index] && i != index) return -1;
    return index;
  }

  public static void main(String[] args) {
    System.out.println(new LargestTwiceArray().largestTwice(new int[] {3, 6, 1, 0}));
    System.out.println(new LargestTwiceArray().largestTwice(new int[] {1, 2, 3, 4}));
  }
}
