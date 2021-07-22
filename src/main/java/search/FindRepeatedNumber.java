package search;

import java.util.Arrays;

/*
   this is variation of finddisappernumber,
   where i items is 1-n and arr length n+1; //at most

   in the case we are looking for the repeated instead of the missing ones
*/
public class FindRepeatedNumber {

  public int findRepeat(int[] numbers) {
    int left = 1;
    int right = numbers.length - 1;

    while (left < right) {
      int mid = (left + right) / 2;
      // System.out.println(mid+" "+ left+ " "+right);
      final int temp = left;
      long count = Arrays.stream(numbers)
          .filter(i -> i >= temp && i <= mid).count();
      if (count > mid - left + 1) right = mid;
      else left = mid + 1;
    }
    return left;
  }

  public static void main(String[] args) {
    //
    FindRepeatedNumber frn = new FindRepeatedNumber();
    System.out.println(frn.findRepeat(new int[]{4, 1, 4, 8, 3, 2, 7, 6, 5}));
  }
}
