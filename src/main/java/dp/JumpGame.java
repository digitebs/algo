package dp;

public class JumpGame {

  static int[] memo;

  // O(n!) to O(n) using memozation
  static boolean jump(int[] arr, int[] memo, int pos) {

    if (pos == arr.length - 1) return true; // if its all ready at the end
    if (pos >= arr.length) return false; // don't even bother
    if (memo[pos] != 0) return memo[pos] == 1; // memoization

    int max = arr[pos];
    for (int i = 1; i <= max; i++) {
      memo[pos + i] = jump(arr, memo, pos + i) ? 1 : -1;
      if (memo[pos + i] == 1) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(jump(new int[] {2, 3, 1, 1, 4}, new int[5], 0));
    System.out.println(jump(new int[] {3, 2, 1, 0, 4}, new int[5], 0));
  }
}
