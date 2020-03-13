package math;

/**
 * two interesting observation here:
 *
 * 1. how to solve for mod
 * 2.the other is java mod result on negative number.
 *    which means you can use mod to check if a number is negative or not
 *
 *
 * *easy problem for confident people
 *
 * You've intercepted an encrypted message, find the original message.
 *
 * Input: "taiaiaertkixquxjnfxxdh"
 * Output: "thisisencryptedmessage"
 * .
 *
 * The initial message "thisisencryptedmessage" was encrypted as follows:
 *
 * letter 0: t -> 19 -> t;
 * letter 1: th -> (19 + 7) % 26 -> 0 -> a;
 * letter 2: thi -> (19 + 7 + 8) % 26 -> 8 -> i; etc.
 *
 * @author john.lim
 */
public class Cipher26 {
    String cipher26(String message) {
        // c = (sum + y)%26
        // c % 26 = sum + y;
        // c-sum %26 = y;


        //
        int sum = 0;
        String ans ="";
        for(char c : message.toCharArray()){
            int d = ((c-97)-sum)%26;
             d+=  (d < 0 ? 26 : 0);
            sum+= d;
            ans+= (char)(97+d);
        }

        return ans;
    }

  public static void main(String[] args) {
    //

      Cipher26 cp = new Cipher26();
      cp.cipher26("taiaiaertkixquxjnfxxdh");
  }
}
