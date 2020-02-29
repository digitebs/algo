package recursion;

/*
   Given an array of equal-length strings,
    you'd like to know if it's possible to rearrange the order of the elements in such a way
     that each consecutive pair of strings differ by exactly one character.'
      Return true if it's possible, and false if not.

    "aba", "bbb", "bab"

    false


    There are 6 possible arrangements for these strings:

    ["aba", "bbb", "bab"]
    ["aba", "bab", "bbb"]
    ["bbb", "aba", "bab"]
    ["bbb", "bab", "aba"]
    ["bab", "bbb", "aba"]
    ["bab", "aba", "bbb"]
    None of these satisfy the condition of consecutive strings differing by 1 character, so the answer is false.
*/
public class StringRearrangement {
  boolean dfs(String[] arr, boolean visited[], int j, int n) {
    if (n == 0) return true;
    visited[j] = true;
    for (int i = 0; i < arr.length; i++) {
      if (!visited[i] && isOneEdit(arr[j], arr[i]) && dfs(arr, visited, i, n - 1)) {
        return true;
      }
    }
    visited[j] = false; // back tracking
    return false;
  }

  boolean stringsRearrangement(String[] arr) {
    // is one edit 2 match
    // the rest should have 2
    // maximum one edit is 2;

    int n = arr.length;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < arr.length; i++) {
      if (dfs(arr, visited, i, n - 1)) return true;
    }
    return false;
  }

  boolean isOneEdit(String a, String b) {
    boolean editOnce = false;
    // lets assume a is smaller
    if (a.length() != b.length()) return false;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) ;
      else if (editOnce == true) return false;
      else editOnce = true;
    }
    return editOnce; // purely one edit
  }

  public static void main(String[] args) {
    //
    StringRearrangement sr = new StringRearrangement();
    System.out.println(sr.stringsRearrangement(new String[] {"aba", "bbb", "bab"}));
    System.out.println(sr.stringsRearrangement(new String[] {"ab", "bb", "aa"}));
    System.out.println(sr.stringsRearrangement(new String[] {"ff", "gf", "af", "ar", "hf"}));
  }
}
