package string;

/*
 given an array of characters reverse the order of words in the arrayseparated by' '.

*/
public class ReverseWords {
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
   * @param str
   * @return
   */
  static char[] reverseString(char[] str) {
    int end = str.length - 1;
    reverse(str, 0, end);
    for (int start = end; start > 0; start--) {
      // check its a space mark teh index
      if (str[start] == ' ') {
        reverse(str, start + 1, end);
        end = start - 1;
      }
    }
    // reverse the last word
    reverse(str, 0, end);

    return str;
  }

  public static void main(String[] args) {
    System.out.println(ReverseWords.reverseString(new char[] {'a', 'b', ' ', 'c', 'd'}));
    System.out.println(
        ReverseWords.reverseString(
            new char[] {
              'r', 'a', 'k', 'u', 't', 'e', 'n', ' ',' ',' ',' ',' ', 'i', 's', ' ', ' ', 'a', 'w', 'e', 's', 'o',
              'm', 'e'
            }));
  }
}
