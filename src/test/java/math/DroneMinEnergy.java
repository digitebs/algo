package math;

/*

Given an array route of 3D points, returns the minimal amount of energy the drone would need to complete its route.
Assume that the drone starts its flight at the first point in route. That is,
 no energy was expended to place the drone at the starting point.

You know that the drone burns 1 kWh (kilowatt-hour is an energy unit) for every mile it ascends, and it gains 1 kWh
for every mile it descends. Flying sideways neither burns nor adds any energy.

For simplicity, every 3D point will be represented as an integer array whose length is 3. Also, the values at indexes
 0, 1, and 2 represent the x, y and z coordinates in a 3D point, respectively.
 */
public class DroneMinEnergy {

  /*
     this is a simple problem but interesting story, all you really need to subract the max height with current location
     height.

     no need to sort as they are on the same y coordinate.
  */
  static int calcDroneMinEnergy(int[][] route) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < route.length; i++) {
      // min = Math.min(route[i][2],min);
      max = Math.max(route[i][2], max);
    }

    return max - route[0][2];
  }

  public static void main(String[] args) {
    System.out.println(
        calcDroneMinEnergy(
            new int[][] {
              {0, 2, 10},
              {3, 5, 0},
              {9, 20, 6},
              {10, 12, 15},
              {10, 10, 8}
            }));
  }
}
