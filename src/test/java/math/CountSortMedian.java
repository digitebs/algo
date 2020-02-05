package math;

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

  public static void main(String[] args) {}
}
