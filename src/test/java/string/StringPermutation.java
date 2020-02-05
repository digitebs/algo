package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
  @Test
  public void testPermute() throws Exception {
    ArrayList<String> arr = new ArrayList();
    permute("", "apple", arr);
    System.out.println(arr);
  }

  public static void permute(String front, String back, List result) {

    if (back.length() == 0) {
      result.add(front);
    } else {
      for (int i = 0; i < back.length(); i++) {
        permute(
            front + back.charAt(i),
            back.substring(0, i) + back.substring(i + 1, back.length()),
            result);
      }
    }
  }

  @Test
  public void isPermution() {

    isPermution("", "cda", "bc");
  }

  private void isPermution(String prefix, String str, String str2) {

    if (0 == str.length()) {
      System.out.println(prefix);
    } else {

      // abc
      // bac
      // bca
      for (int i = 0; i < str.length(); i++) {
        isPermution(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), str2);
      }
    }
  }
}
