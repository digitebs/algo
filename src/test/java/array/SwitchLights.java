package array;

import java.util.Arrays;

/*

   given an array of candles. if  candle is lit  then teh state of this candle and before it are change to opposite
   which candle will remain lit after  applying to all candles.

    [1, 1, 1, 1, 1] => [0, 1, 0, 1, 0]

    Explanation:
    1 1 1 1 1
    0 1 1 1 1
    1 0 1 1 1
    0 1 0 1 1
    1 0 1 0 1
    0 1 0 1 0

    [0, 0] => [0, 0]

    [1, 0, 0, 1, 0, 1, 0, 1] => [1, 1, 1, 0, 0, 1, 1, 0]
*/
public class SwitchLights {

  //n^2. space and time
  int[] switchLights2(int[] a) {
    int n = a.length;
    int[] c = Arrays.copyOf(a, n);
    for (int j = 0; j < n; j++) {
      if (c[j] != 1) continue;
      for (int i = 0; i <= j; i++) {
        a[i] = a[i] == 1 ? 0 : 1; // ^b[i];
      }
    }
    return a;
  }


  // O(n)
  int[] switchLights(int[] a) {
    int n = a.length;
    int flip = 0;
    for (int j = n - 1; j >= 0; j--) {
      if (a[j] == 1) flip++;
      a[j] = a[j] == flip % 2 ? 0 : 1;
    }
    return a;
  }

  public static void main(String[] args) {
    SwitchLights sl = new SwitchLights();
    System.out.println(Arrays.toString(sl.switchLights(new int[] {1, 0, 0, 1, 0, 1, 0, 1})));
    System.out.println(Arrays.toString(sl.switchLights(new int[] {1, 1, 1, 1, 1})));
    System.out.println(Arrays.toString(sl.switchLights(new int[] {0, 0})));
  }
}
