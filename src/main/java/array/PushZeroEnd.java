package array;

import java.util.Arrays;


/*
    push zero at the end of array
 */
public class PushZeroEnd {

  // damn 2 loops one is to check its zero
  // n2
  static void push(int[] num) {
    for (int i = 0; i < num.length; i++) {
      if (num[i] == 0)
        for (int j = i; j < num.length - 1; j++) {
          num[j] = num[j + 1];
          num[j + 1] = 0;
        }
    }
  }

  // linear, just override then increase position
  // O(n)
  static void push2(int[] num) {
    int pos = 0;
    for (int i = 0; i < num.length; i++) {
      if (num[i] != 0) num[pos++] = num[i];
    }

    for (int i = num.length - 1; i > pos; i--) num[i] = 0;
  }

  static void push3(int[] num) {
    int pos = 0;
    for (int i = 0; i < num.length; i++) {
      if (num[i] != 0) {
        num[pos++] = num[i];
        num[i] = 0;
        //pos = i;
      }
      System.out.println(Arrays.toString(num));
    }

   // for (int i = num.length - 1; i > pos; i--) num[i] = 0;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {0,1,0,0, 2, 3, 4, 0,5,0,0};
    push3(arr);
    System.out.println(Arrays.toString(arr));
  }
}
