package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/*
Given an array a that contains only numbers in the range from 1 to a.length,
 find the first duplicate number for which the second occurrence has the minimal index.

  In other words, if there are more than 1 duplicated numbers,
   return the number for which the second occurrence has a smaller index
   than the second occurrence of the other number does. If there are no such elements, return -1.

  Input: 3, 4, 1, 4, 1
  Output: 4


   *its just means return the 1st duplicate you find by iterating
 */
public class FirstDuplicate {
  public int firstDuplicate(final int[] a) {
    int[] index = new int[a.length + 1];
    for (int i = 0; i < a.length; i++) {
      if (index[a[i]]++ > 0) return a[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    //
    FirstDuplicate fd = new FirstDuplicate();
    System.out.print(fd.firstDuplicate(new int[]{3, 4, 1, 4, 1}));
  }
}
