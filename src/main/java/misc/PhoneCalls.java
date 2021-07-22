package misc;

/*

Some phone usage rate may be described as follows:

first minute of a call costs min1 cents,
each minute from the 2nd up to 10th (inclusive) costs min2_10 cents
each minute after 10th costs min11 cents.
You have s cents on your account before the call.
 What is the duration of the longest call (in minutes rounded down to the nearest integer) you can have?


Here's why:

the first minute costs 3 cents, which leaves you with 20 - 3 = 17 cents;
the total cost of minutes 2 through 10 is 1 * 9 = 9, so you can talk 9 more minutes and still have 17 - 9 = 8 cents;
each next minute costs 2 cents, which means that you can talk 8 / 2 = 4 more minutes.
Thus, the longest call you can make is 1 + 9 + 4 = 14 minutes long.
 */
public class PhoneCalls {
    int phoneCall(int min1, int min2_10, int min11, int s) {
        int i = 0, cost = min1;
        while((s -= cost) >= 0){
            i++;
            if(i >= 1 && i <10) cost=min2_10;
            else cost = min11;
        }
        return i;
    }

  public static void main(String[] args) {
    //
      PhoneCalls pc = new PhoneCalls();
      System.out.println(pc.phoneCall(3,1,2,20));
  }
}
