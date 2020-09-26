package string;

import java.util.Deque;
import java.util.Queue;

/*
 given a string rotate the the character for A-Z, a-z, and 0-9

 input = Zebra-493?
 rotationFactor = 3
 output = Cheud-726?

*/
public class RotationalCipher {
  String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
    String res = "";
    for (char c : input.toCharArray()) {
      int n = c;
      if (Character.isLetter(c)) {
        if (Character.isLowerCase(c)) n = 'a' + ((c - 'a') + rotationFactor) % 26;
        else n = 'A' + ((c - 'A') + rotationFactor) % 26;
      } else if (Character.isDigit(c)) {
        n = '1' + ((c - '1') + rotationFactor) % 10;
      }
      res += (char) n;
    }

    return res;
  }

  public static void main(String[] args) {
    RotationalCipher rc = new RotationalCipher();

    System.out.println(rc.rotationalCipher("All-convoYs-9-be:Alert1.", 4));
    System.out.println(rc.rotationalCipher("abcdZXYzxy-999.@", 4));

  }
}
