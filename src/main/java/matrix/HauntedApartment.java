package matrix;

/*
     x employees decided o take  a holiday and book an apartment.

    given an nxm cost of rooms in the apartment, find the total cost that is available for employees to stay.

    if any of the room is haunted in the upper floor, nobody will want to stay in its lower floor

    consider 0 as haunted.


    Input:
              {0,1,1,2}
              {0,5,0,0}
              {2,0,3,3}

    Output: 9 (1+1+2+5)

 */
public class HauntedApartment {

    /* use the 1st column as store */
  int matrixElementsSum(int[][] matrix) {
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[0][j] == 0) continue;
        sum += matrix[0][j] = matrix[i][j];
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    //
      HauntedApartment ag = new HauntedApartment();
      System.out.println(ag.matrixElementsSum(new int[][]{
              {0,1,1,2},
              {0,5,0,0},
              {2,0,3,3}
      }));
  }
}
