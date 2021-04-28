package combination;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/*
  given a string input. return all string permutation

  input: abc
  output:
  abc
  acb
  bac
  bca
  cab
  cba


  input: rakuten
 */
public class StringPermutation {
  @Test
  public void testPermute() throws Exception {
    // permute("", "apple");
   // permute("", "abc");
    permute("", "rakuten");
  }

  public static void permute(String front, String back) {

    if (back.length() == 0) {
      System.out.print(front+",");
    } else {
      for (int i = 0; i < back.length(); i++) {
        permute(
            front + back.charAt(i),
            back.substring(0, i) + back.substring(i + 1, back.length()));
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
