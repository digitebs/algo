package greedy;

import java.util.stream.IntStream;

/** Created by johnlim on 7/3/17. */
public class MinSlice {
  public void slice() {
    int[] A = new int[] {1, 2, 3, 4, 5};

    int right = IntStream.of(A).sum(); // 15
    int left = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < A.length - 1; i++)
      min = Math.min(Math.abs((left += A[i]) - (right -= A[i])), min);
    System.out.print(min);
  }
}
