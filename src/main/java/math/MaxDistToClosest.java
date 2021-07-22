package math;

/*

In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

 */
public class MaxDistToClosest {
  /*
     the tricky part here is the cases where
     1. in the beginning
     2. in the middle
     3. at the end
  */
  static int maxDistToClosest(int[] seats) {
    int l = 0;
    int r = 0;
    int max = 0;
    while (seats[r] != 1) {
      max = Math.max(max, (++r - l));
    }
    int i = r;
    for (; i < seats.length; i++) {
      if (seats[i] == 1) {
        l = r;
        r = i;
      }
      max = Math.max(max, (r - l) / 2);
    }
    if (seats[i - 1] == 0) {
      max = Math.max(max, i - 1 - r);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(MaxDistToClosest.maxDistToClosest(new int[] {1, 0, 0, 0, 0, 1}));
    System.out.println(MaxDistToClosest.maxDistToClosest(new int[] {1, 0, 0, 0, 0, 0, 1}));
    System.out.println(MaxDistToClosest.maxDistToClosest(new int[] {0, 0, 1, 0, 0, 1}));
    System.out.println(MaxDistToClosest.maxDistToClosest(new int[] {1, 0, 0, 1, 0, 0}));
  }
}
