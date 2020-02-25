package sort;

import java.util.Arrays;


/*

     given array of sorted free timeslot(start,end) of 2 person. find a timeslot where both person
     can attend the meeting given the meeting last k time.

      Input:
      k = 8
      person a:
      {
        {10, 50},
        {50, 120},
        {140, 210}
      }

      person b:
      {
        {0, 15},
        {60, 70}
      }

      Output: [60, 68]
 */
public class MeetingPlanner {
  /*
     can use 2 pointer since they are sorted by start time.
     m + k
  */
  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    int i = 0;
    int j = 0;
    while (i < slotsA.length && j < slotsB.length) {
      int start = Math.max(slotsA[i][0], slotsB[j][0]);
      int end = Math.min(slotsA[i][1], slotsB[j][1]);

      if (start + dur <= end) {
        return new int[] {start, start + dur};
      } else if (slotsA[i][1] < slotsB[j][1]) {
        i++;
      } else if (slotsA[i][1] == slotsB[j][1]) {
        i++;
        j++;
      } else {
        j++;
      }
    }

    return new int[] {};
  }

  public static void main(String[] args) {

    System.out.println(
        Arrays.toString(
            meetingPlanner(
                new int[][] {
                  {10, 50},
                  {50, 120},
                  {140, 210}
                },
                new int[][] {
                  {0, 15},
                  {60, 70}
                },
                8)));
  }
}
