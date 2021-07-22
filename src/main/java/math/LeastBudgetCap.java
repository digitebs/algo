package math;

import java.util.Arrays;

/*
   Find the cap that impacts least amount of recipients in a grantsArray
   where all elements in grantsArray is < cap

   and the sum of grantsArray return should be == the given newBudget

   input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190

   output: 47 # and given this cap the new grants array would be
           # [2, 47, 47, 47, 47]. Notice that the sum of the
           # new grants is indeed 190
*/
public class LeastBudgetCap {
  static double leastBudgetCap(double[] grantsArray, double newBudget) {
    Arrays.sort(grantsArray); // sort it means the biggest grant s on right side
    double currBudget = Arrays.stream(grantsArray).sum(); // calculate the currentBudget
    for (int i = grantsArray.length - 1; i > 0; i--) {
      int elements = (grantsArray.length - i); // track how many grants we have touch
      double budgetCap = (grantsArray[i] - grantsArray[i - 1]);
      double toCapAvg = budgetCap * elements;
      if (currBudget - toCapAvg > newBudget) {
        // current budget still greater than budget after flatten
        currBudget -= toCapAvg;
      } else {
        // we should return the remaining
        double leftOverAvg = (currBudget - newBudget) / elements;
        return grantsArray[i] - leftOverAvg; // subtract it on our current element as avg
      }
    }
    return newBudget / grantsArray.length;
  }

  public static void main(String[] args) {
    //  System.out.println(LeastBudgetCap.leastBudgetCap(new int[]{100,120,50,2,1000},190));
    // System.out.println(LeastBudgetCap.leastBudgetCap(new int[]{1,2,3,4,5},10));
    System.out.println(LeastBudgetCap.leastBudgetCap(new double[] {2, 4}, 3));
    //
  }
}
