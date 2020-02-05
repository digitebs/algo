package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [[4, 4, 4, 4, 4, 4, 4], [4, 3, 3, 3, 3, 3, 4], [4, 3, 2, 2, 2, 3, 4], [4, 3, 2, 1, 2, 3, 4], [4,
 * 3, 2, 2, 2, 3, 4], [4, 3, 3, 3, 3, 3, 4], [4, 4, 4, 4, 4, 4, 4]]
 */
public class PrettyPrint {
  public ArrayList<ArrayList<Integer>> prettyPrint(int a) {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    int rowSize = a * 2 - 2;
    for (int i = 0; i <= rowSize; i++) {
      ArrayList row = new ArrayList<>(Arrays.asList(new Integer[rowSize + 1]));
      result.add(row); // intialize list of arrays
    }
    // i is your layer
    for (int i = 0; i <= rowSize; i++) {
      // top; bottom
      for (int j = i; j <= rowSize - i; j++) {
        result.get(i).set(j, a - i);
        result.get(rowSize - i).set(j, a - i);
        result.get(j).set(i, a - i);
        result.get(j).set(rowSize - i, a - i);
      }
    }

    return result;
  }

  @Test
  public void prettyPrint() {
    System.out.println(prettyPrint(4));
  }
}
