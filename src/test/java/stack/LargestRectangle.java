package stack;

import java.util.Arrays;
import java.util.Stack;


/*
    given an array of with building height, find the largest rectangular banner area  that can be attached to the building

       X
      ..
      ..
      .. X
    X ..XX
    XX..XX

    Input: [2,1,5,6,2,3]
    Output: 10
 */
public class LargestRectangle {

    // O(n) using stack
  public int largestRectangleArea2(int[] heights) {
    int max = 0;
    int n = heights.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
        stack.pop();
      left[i] = i - (stack.isEmpty() ? -1 : stack.peek());
      stack.push(i);
    }
    stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
        stack.pop();
      right[i] = (stack.isEmpty() ? n : stack.peek()) - i;
      stack.push(i);
      // System.out.println(stack);
    }

    for (int i = 0; i < n; i++) {
      int sum = (left[i] + right[i]) * heights[i];
      max = Math.max(sum - heights[i], max);
    }
    return max;
  }

  /* O(1) space but complexity is n^2 */
  public int largestRectangleArea(int[] heights) {
    int max = 0;
    int n = heights.length;

    for (int i = 0; i < n; i++) {
      int left = 1;
      int min = heights[i];
      for (int j = i - 1; j >= 0 && heights[i] <= heights[j]; j--) {
        left++;
      }

      // sum += left*heights[i];

      int right = 1;
      for (int j = i + 1; j < heights.length && heights[i] <= heights[j]; j++) {
        right++;
      }
      int sum = (left + right) * heights[i];

      max = Math.max(sum - heights[i], max);
    }
    return max;
  }

  public static void main(String[] args) {
      LargestRectangle largestRectangle = new LargestRectangle();
      System.out.println(largestRectangle.largestRectangleArea2(new int[]{2,1,5,6,2,3}));
      System.out.println(largestRectangle.largestRectangleArea2(new int[]{2,1,2}));
      System.out.println(largestRectangle.largestRectangleArea2(new int[]{1,2,2}));
  }
}
