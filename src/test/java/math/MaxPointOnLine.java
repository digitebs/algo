package math;

import java.util.HashMap;

/*
given a set of points find the max point in a line
*/
public class MaxPointOnLine {
  int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  HashMap<String, Integer> slop = new HashMap<>();

  public int maxPoints(int[][] points) {
    if (points.length == 0) return 0;
    int max = 1;
    for (int i = 0; i < points.length; i++) {
      int x = points[i][0];
      int y = points[i][1];
      for (int j = 0; j < points.length; j++) {
        int xDiff = points[j][0] - x;
        int yDiff = points[j][1] - y;
        int g = Math.abs(gcd(xDiff, yDiff));
        if (g == 0) g = 1;
        String key = (xDiff / g) + "/" + (yDiff / g);
        slop.put(key, slop.getOrDefault(key, 0) + 1);
        max =
            Math.max(
                max, (xDiff == 0 && yDiff == 0 ? 0 : slop.get(key)) + slop.getOrDefault("0/0", 0));
      }
      slop.clear();
    }
    return max;
  }
}
