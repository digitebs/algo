package bit;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/** Created by johnlim on 3/2/17. */
public class LeetCodeBinary {

  @Test
  public void guessNumber() {
    guessNumber(10);
  }

  public int guessNumber(int n) {
    int start = 1;
    int end = n;

    while (start < end) {
      System.out.println(start);
      int mid = start + (end - start + 1) / 2;
      // if(guess(mid)==-1){
      start = mid;
      /* }else if(guess(mid)==1){
          start=mid;
      }else{
          return mid;
      }*/
    }
    return 1;
  }
}
