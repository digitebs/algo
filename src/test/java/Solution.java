import java.util.ArrayList;
import java.util.stream.Stream;

/** Created by johnlim on 10/2/16. */
public class Solution {
  public static void main(String args[]) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");

    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      System.out.println(string);
    }

  }
}
