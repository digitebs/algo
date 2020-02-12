package string;

import java.util.Arrays;

/*
http://www.nayuki.io/page/next-lexicographical-permutation-algorithm
*/
public class NextLexograpical {

  static char[] swap(char[] arr, int i, int j) {
    char t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
    return arr;
  }

  static void reverse(char[] arr, int start, int end) {
    // for(int i =end-1;i< start;i--){
    // check its a space mark teh index
    while (start < end) {
      // swap
      swap(arr, start, end);
      start++;
      end--;
    }
  }

  static String biggerIsGreater(String str) {
    char[] chars = str.toCharArray();
    int i = chars.length - 1;
    while (i > 0 && chars[i] <= chars[i - 1]) i--;
    if (i <= 0) return "no answer";
    int j = chars.length - 1;
    while (chars[j] <= chars[i - 1]) j--;
    swap(chars, j, i - 1);
    reverse(chars, i, chars.length - 1);
    return new String(chars);
  }

  public static void main(String[] args) {

    // lmon
    System.out.println(biggerIsGreater("lmno"));
    // hcdkx

    System.out.println(biggerIsGreater("dcba"));
    System.out.println(biggerIsGreater("dcbb"));
    System.out.println(biggerIsGreater("abdc"));
    System.out.println(biggerIsGreater("abcd"));
    System.out.println(biggerIsGreater("fedcbabcd"));

    System.out.println(biggerIsGreater("ab"));
    System.out.println(biggerIsGreater("bbb"));
    System.out.println(biggerIsGreater("hefg")); // g > f
    System.out.println(biggerIsGreater("dhck"));

    // hcdk lex */
    System.out.println("cdkh " + biggerIsGreater("cdkh")); // h > k?? false
  }
}
