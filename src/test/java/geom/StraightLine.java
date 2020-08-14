package geom;

/** @author john.lim */
public class StraightLine {
  public boolean checkStraightLine(int[][] arr) {
    int x = arr[0][0] - arr[1][0];
    int y = arr[0][1] - arr[1][1];

    for (int i = 1; i < arr.length; i++) {
      int x1 = arr[i - 1][0] - arr[i][0];
      int y1 = arr[i - 1][1] - arr[i][1];

      if ((double) y / x != (double) y1 / x1) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    //
    StraightLine sl = new StraightLine();
    System.out.println(
        sl.checkStraightLine(new int[][] {{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}}));
    // System.out.println(sl.checkStraightLine(new int[][]{{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}}));
  }
}
