package dp;

/*
Given a list of trips, trip[i] = [num_passengers,
 start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up,
  and the locations to pick them up and drop them off.
    The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 */
public class CarPooling {
  /*
     use the interval as locations where people come and go; // time and space can be interchange

     gather data.

     Input: trips = [[2,1,5],[3,3,7]], capacity = 4
     Output: false
  */
  public static final int MAX_LOCATIONS = 1001; // since 0 <= trips[i][1] < trips[i][2] <= 1000

  public boolean carPooling(int[][] trips, int capacity) {
    int locations[] = new int[MAX_LOCATIONS];
    for (int[] t : trips) {
      int num_passengers = t[0];
      int start = t[1];
      int end = t[2];
      locations[start] += num_passengers;
      locations[end] -= num_passengers;
    }
    /* visit all locations and check whether its visited or not */
    int count = 0;
    for (int i = 0; i < MAX_LOCATIONS; i++) {
      count += locations[i];
      if (count > capacity) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new CarPooling().carPooling(new int[][] {{2, 1, 5}, {3, 3, 7}}, 4));
  }
}
