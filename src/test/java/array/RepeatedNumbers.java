package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RepeatedNumbers {
  public int repeatedNumber(final List<Integer> a) {
    int[] index = new int[a.size() + 1];
    for (int i = 0; i < a.size(); i++) {
      index[a.get(i)]++;
      if (index[a.get(i)] == 2) return a.get(i);
    }

    return -1;
  }

  @Test
  public void repeatedNumber() {
    System.out.print(repeatedNumber(Arrays.asList(3, 4, 1, 4, 1)));
  }
}
