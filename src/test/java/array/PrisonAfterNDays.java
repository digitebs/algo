package array;

import java.util.*;

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
        Arrays.toString(pAnD.prisonAfterNDays(new int[] {1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)));
    //  Arrays.toString(pAnD.prisonAfterNDays(new int[]{1,1,0,1,1,0,1,1},6))
    // Arrays.toString(pAnD.prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7)));
  }
}
