package sort;

import java.util.Arrays;

/**
 * sorting where the lower x goes to teh top, and the lower y goes to the bottom * where the mid has
 * the highest x and y.
 *
 * double sort technique, top and bottom
 *
 * then you sum from top and bottom
 *
 There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 and the cost of flying the i-th person to city B is costs[i][1].

 Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 Input: [[10,20],[30,200],[400,50],[30,20]]
 Output: 110
 Explanation:
 The first person goes to city A for a cost of 10.
 The second person goes to city A for a cost of 30.
 The third person goes to city B for a cost of 50.
 The fourth person goes to city B for a cost of 20.

 The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

 */
public class TwoSortedCity {
  public int twoCitySchedCost(int[][] costs) {

    Arrays.sort(
        costs,
        (arr1, arr2) -> {

          // arr1[0]-arr1[1] negative means  x is smaller than y, forces x to go to the 1st
          // interestingly if the gap is bigger it goes higher in the list
          // so you sort by x and y as well as the gap
          return arr1[0] - arr1[1] - (arr2[0] - arr2[1]);
        });

    // all the lower y goes to bottom
    // all the lower x goes to top
    for (int[] c : costs) System.out.println(Arrays.toString(c));
    int i = 0, j = costs.length - 1;
    int sum = 0;
    while (i < j) sum += costs[i++][0] + costs[j--][1];
    return sum;
  }

  public static void main(String[] args) {
      TwoSortedCity tsc = new TwoSortedCity();
    System.out.println(tsc.twoCitySchedCost(new int[][]{
            {10,20},
            {30,200},
            {400,50},
            {30,20}
    }));
  }
}
