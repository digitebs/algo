package string;

/**
 * given an array of characters reverse the order of words in the arrayseparated by' '.
 *
 * @author john.lim
 */
public class SentenceReverse {
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

  static char[] swap(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
    return arr;
  }

  /**
   * it doest use any buffer space excpet the current buffer
   *
   * @param chars
   * @return
   */
  static char[] reverseString(char[] chars) {
    int end = chars.length - 1;
    reverse(chars, 0, end);
    int s = 0;
    for (int i = 0; i <= chars.length; i++) {
      if (i == chars.length || chars[i] == ' ') {
        reverse(chars, s, i - 1);
        s = i + 1; // use 1 space
      }
    }
    // reverse the last word
    // reverse(str, 0, end);

    return chars;
  }

  public static void main(String[] args) {
    System.out.println(reverseString(new char[] {'a', 'b', ' ', 'c', 'd'}));
    System.out.println(
        reverseString(
            new char[] {
              'r', 'a', 'k', 'u', 't', 'e', 'n', ' ', ' ', ' ', ' ', ' ', 'i', 's', ' ', ' ', 'a',
              'w', 'e', 's', 'o', 'm', 'e'
            }));
  }
}
