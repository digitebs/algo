package stack;

import java.util.Stack;

/*
Given array of integers, for each position i,
 search among the previous positions for the last (from the left) position that contains a smaller value
 . Store this value at position i in the answer. If no such value can be found, store -1 instead.

    Input: [3, 5, 2, 4, 5]
    Output: [-1, 3, -1, 2, 4].
 */
public class ArrayPreviousLess {
  int[] arrayPreviousLess(int[] items) {
    int n = items.length;
    /*int[] res = new int[n];
    for(int i = 0; i < n; i++){
      boolean found = false;
      for(int j = i-1 ; j >= 0; j--){
        if(items[i] > items[j]){
          found = true;
          res[i] = items[j];
          break;
        }
      }
      if(!found) res[i] = -1;
    }*/

    int[] res = new int[n];
    Stack<Integer> s = new Stack<>();
    s.push(-1);
    for (int i = 0; i < n; i++) {
      while (items[i] <= s.peek()) // at most n element so this is 2n
      s.pop(); // keep on pop
      res[i] = s.peek();
      s.push(items[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    ArrayPreviousLess apl = new ArrayPreviousLess();
    System.out.println(apl.arrayPreviousLess(new int[] {3, 5, 2, 4, 5}));
    System.out.println(apl.arrayPreviousLess(new int[] {2, 2, 1, 3, 4, 5, 5, 3}));
  }
}
