package math;


/*

Ignore*

  d = 3 , e = {10,20,30,40,50} and . On the first three days,
  they just collect spending data.
  At day 4, we have trailing expenditures of 10,20,30.
   The median is 20 and the day's expenditure is 40. Because 40>= 2*20, there will be a notice.
    The next day, our trailing expenditures are {20,30,40} and the expenditures are 50.
     This is less than 2*50 so no notice will be sent. Over the period, there was one notice sent.


max expenditure is 1 to 200

Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest.
 If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers,
  median is then defined to be the average of the two middle values. (Wikipedia)
 */
public class CountSortMedian {
  // counting sort only works with limited number of items
  static double median(int[] count, int d) {
    int prev = -1, i = 0;
    for (int j = count[i]; i < count.length; j += count[++i]) {
      if (j == d / 2) prev = i;
      if (j > d / 2) break;
    }
    return d % 2 == 1 ? i : i + (prev == -1 ? i : prev) / 2.0;
  }

  static int activityNotifications(int[] expenditure, int d) {
    int[] sort = new int[201];
    int count = 0;
    for (int i = 0; i < d; i++) sort[expenditure[i]] += 1;
    for (int i = 0; i < expenditure.length - d; i++) {
      if (expenditure[d + i] >= 2 * median(sort, d)) count++;
      sort[expenditure[i]] -= 1;
      sort[expenditure[d + i]] += 1;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(activityNotifications(new int[] {1, 2, 3, 4, 4}, 5));
    System.out.println(activityNotifications(new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
  }
}
