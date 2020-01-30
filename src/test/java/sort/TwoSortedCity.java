package sort;

import java.util.Arrays;


/**
 * sorting where the lower x goes to teh top, and the lower y goes to the bottom
 **  where the mid has the highest x and y.
 *
 *  double sort technique, top and bottom
 *
 * then you sum from top and bottom
 *
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *   1
 *  111
 * 1111
 * 111
 *  1
 *

 */
public class TwoSortedCity {
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs,(arr1, arr2)->{

            // arr1[0]-arr1[1] negative means  x is smaller than y, forces x to go to the 1st
            // interestingly if the gap is bigger it goes higher in the list
            // so you sort by x and y as well as the gap
            return arr1[0]-arr1[1]-(arr2[0]-arr2[1]);
        });

        // all the lower y goes to bottom
        // all the lower x goes to top
        for(int[] c: costs)
            System.out.println(Arrays.toString(c));
        int i=0,j=costs.length-1;
        int sum = 0;
        while(i<j)
            sum+=costs[i++][0]+costs[j--][1];
        return sum;
    }
}
