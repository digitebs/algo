package string;

import java.util.Arrays;

/**
 *
 * easy*
 *
 * given an array string  and n, where n is the actual length of string excluding the space at the end.
 *
 * replace all ' ' with '0' '2' '%'. assuming the given array will always have extra space to fit the newly
 * encoded string
 *
 * assuming the character has enough space:- reverse traverse, with a pointer at the end
 *
 * Input:
 * [rakuten is awseome    ]
 * Output:
 * [rakuten%20is%20awseome]
 * */
public class URLify {
  static void URLify(char[] arr, int n) {
    int j = arr.length - 1; // push it back to the end
    for (int i = n - 1; i >= 0; i--) {
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
