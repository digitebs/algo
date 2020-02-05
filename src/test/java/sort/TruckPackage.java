package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TruckPackage {
  ArrayList<Integer> IDsOfPackages(int truckSpace, ArrayList<Integer> packagesSpace) {
    // WRITE YOUR CODE HERE
    ArrayList<Integer> idx = new ArrayList<>();
    for (int i = 0; i < packagesSpace.size(); i++) idx.add(i);
    idx.sort(Comparator.comparingInt(packagesSpace::get));

    int i = 0;
    int j = idx.size() - 1;
    int n = truckSpace - 30; // max allowed
    while (i != j) {
      int sum = packagesSpace.get(idx.get(i)) + packagesSpace.get(idx.get(j));
      if (sum < n) i++;
      else if (sum > n) j--;
      else return new ArrayList<>(Arrays.asList(idx.get(i), idx.get(j)));
    }
    // impossible exactly one solution
    return new ArrayList<>();
  }

  public static void main(String[] args) {
    System.out.println(
        new TruckPackage()
            .IDsOfPackages(110, new ArrayList<>(Arrays.asList(20, 70, 90, 30, 60, 110))));
  }
}
