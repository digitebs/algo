package array;

import java.util.Arrays;

/*


Sitting arrangement rotation

Input:

              [["empty", "Alice", "empty"],
             ["Bob",   "empty", "Charlie"],
             ["empty", "Dave",  "empty"],
             ["Eve",   "empty", "Frank"]]
             K = 2

Output:
             [
             [empty, Frank, empty],
              [Charlie, empty, Dave],
               [empty, Bob, empty],
                [Alice, empty, Eve]
                ]


 */
public class ArrayRotateVolleyball {
  String[][] volleyballPositions(String[][] formation, int k) {
    String[] temp = {
      formation[0][1],
      formation[1][2],
      formation[3][2],
      formation[2][1],
      formation[3][0],
      formation[1][0]
    };

    rotateReverse(temp, k);
    formation[0][1] = temp[0];
    formation[1][2] = temp[1];
    formation[3][2] = temp[2];
    formation[2][1] = temp[3];
    formation[3][0] = temp[4];
    formation[1][0] = temp[5];

    return formation;
  }

  // counter clockwise, means to the left
  public void rotateReverse(String[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  public void reverse(String[] nums, int start, int end) {
    while (start < end) {
      String temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
      ArrayRotateVolleyball ar = new ArrayRotateVolleyball();
    System.out.println(Arrays.deepToString(
    ar.volleyballPositions(new String[][]{
              {"empty", "Alice", "empty"},
              {"Bob",   "empty", "Charlie"},
              {"empty", "Dave",  "empty"},
              {"Eve",   "empty", "Frank"}
      },2)));
  }
}
