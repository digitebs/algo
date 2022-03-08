package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlippingMatrix {
  /*
   * Complete the 'flippingMatrix' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
   */

  public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here

    int n = matrix.size();
    int sum = 0;
    for (int i = 0; i < n / 2; i++) {
      int e;
      for (int j = 0; j < n / 2; j++) {
        int a = matrix.get(i).get(j);
        int b = matrix.get(i).get(n - j - 1);
        int c = matrix.get(n - i - 1).get(j);
        int d = matrix.get(n - i - 1).get(n - j - 1);
        e = Math.max(Math.max(Math.max(a, b), c), d);
        sum += e;
      }
    }
    return sum;
  }

  public static void main(String[] args) {

    List<List<Integer>> m = new ArrayList<>();
    m.add(Arrays.asList(112,42,83,119));
    m.add(Arrays.asList(56,125,56,49));
    m.add(Arrays.asList(15,78,101,43));
    m.add(Arrays.asList(62,98,114,108));
    System.out.println(FlippingMatrix.flippingMatrix(m));
  }
}
