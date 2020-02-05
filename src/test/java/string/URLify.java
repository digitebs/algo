package string;

import java.util.Arrays;

/** assuming the character has enough space:- reverse traverse, with a pointer at the end */
public class URLify {
  static void URLify(char[] arr, int e) {
    int j = arr.length - 1; // push it back to the end
    for (int i = e - 1; i >= 0; i--) {
      if (arr[i] == ' ') {
        arr[j--] = '0';
        arr[j--] = '2';
        arr[j--] = '%';
      } else {
        arr[j--] = arr[i];
      }
    }
  }

  public static void main(String[] args) {
    char[] arr = {'a', ' ', 'b', ' ', ' '};
    URLify(arr, 3);
    System.out.println(Arrays.toString(arr));
  }
}
