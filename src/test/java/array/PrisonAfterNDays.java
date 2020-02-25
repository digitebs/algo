package array;

import java.util.Arrays;

/*
  given an array of lightbulb and n days, find the state of lightbulb after n days
  each day the state of the lightbulb changes base on:
  1. if the adjacent lightbulb are the same you turn it on
  2. else turn off, the 1st and last element has only 1 adjacent lightbulb thus turn off

  {0 1 0 0 0 0 0 1}, n = 1

  [0 1 0 1 1 1 0 0] 1
  [0 1 1 0 1 0 0 0] 2
 */
public class PrisonAfterNDays {
  public int[] prisonAfterNDays(int[] cells, int N) {
    int m = cells.length;
    int[][] arr = new int[14][];
    for (int d = 0; d < arr.length; d++) { // 14 is all possible before repeat
      int[] temp = new int[m];
      for (int i = 1; i < m - 1; i++) {
        temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
      }
      arr[d] = cells = temp;
    }
    return arr[(N - 1) % arr.length];
  }

  public static void main(String[] args) {
    PrisonAfterNDays pAnD = new PrisonAfterNDays();
    System.out.println(
        Arrays.toString(pAnD.prisonAfterNDays(new int[] {1, 1, 0, 1, 1, 0, 1, 1}, 6)));
    System.out.println(
        Arrays.toString(pAnD.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)));
    System.out.println(
        Arrays.toString(pAnD.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7)));
    System.out.println(
        Arrays.toString(pAnD.prisonAfterNDays(new int[] {0, 1, 0, 0, 0, 0, 0, 1}, 10)));
  }
}
