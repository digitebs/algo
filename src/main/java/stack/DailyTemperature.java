package stack;

import java.util.Arrays;
import java.util.Stack;

/*

Easy* tricky to optimize

Given a list of daily temperatures T, return a list such that, for each day in the input,
 tells you how many days you would have to wait until a warmer temperature.
  If there is no future day for which this is possible, put 0 estioninstead.
 */
public class DailyTemperature {
  /*
     using stack and scanning backward instead of forward, stores the index to track the day with >= count
  */
  public int[] dailyTemperatures(int[] T) {
    int[] ans = new int[T.length];
    Stack<Integer> stack = new Stack();
    for (int i = T.length - 1; i >= 0; --i) {
      while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
      ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] ans =
        new DailyTemperature().dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});

    System.out.println(Arrays.toString(ans));
  }
}
