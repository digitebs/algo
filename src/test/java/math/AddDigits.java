package math;

/**
    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

    <b>Example:</b>


    <b>Input:</b> 38
    <b>Output:</b> 2
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
                 Since 2 has only one digit, return it.
 */
public class AddDigits {

  public int addDigits(int num) {
    if (num < 10) return num;
    int sum = 0;
    do {
      sum += num % 10;
      // System.out.println(sum + " "+ num%10);
    } while ((num = num / 10) > 0);
    return addDigits(sum);
  }

  public static void main(String[] args) {
    //
    System.out.println(new AddDigits().addDigits(19));
  }
}
