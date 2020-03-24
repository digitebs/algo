package search;

public class RootNumber {
  /*
     root of a number

     false position method
        newton method // using tangent line, 1 point
        secant line // using triangle, 2 points
     bisection method
  */
  static double root(double x, int n) {
    final double E = 0.001; // precision
    double right = x;
    double left = 0;
    while (left < right) {
      double mid = (right + left) / 2;
      double num = Math.pow(mid, n);
      if (Math.abs(num - x) <= E) {
        return Double.parseDouble(String.format("%.3f", mid));
      } else if (x < num) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // y ^ 3 = 7;
    // logy 7 = 3
    System.out.println(root(7, 3));
  }
}
