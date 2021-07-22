package sort;

import java.util.Arrays;
import java.util.Comparator;

/*
  We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)


1 <= K <= points.length <= 10000

 */
public class ClosestPointToOrigin {
  static int[][] kClosest(int[][] points, int K) {

    Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

    int[][] res = new int[K][];
    System.arraycopy(points, 0, res, 0, K);
    return res;
  }

  public static void main(String[] args) {
    int[][] res = kClosest(new int[][] {{1, 3}, {-2, 2}}, 1);

    for (int[] r : res) {
      System.out.println(Arrays.toString(r));
    }
  }
}
