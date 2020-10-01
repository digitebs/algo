package greedy;

/*
  given an table array of people height, the table is circular, the awkwardness is teh differences between
  height of 2 adjacent seating position.

  The overall awkwardness of the seating arrangement is then defined as the maximum awkwardness
   of any pair of adjacent guests per seating arrangement.
    Determine the minimum possible overall awkwardness of any seating arrangement.

    Note that there are n! possible permutations of seat assignments.

  n = 4
  arr = [5, 10, 6, 8]
  output = 4
 */
public class SeatingArrangements {
  // Add any helper functions you may need he
  void swap(int[] arr, int i, int j) {
    arr[j] = arr[j] ^ arr[i] ^ (arr[i] = arr[j]);
  }

  int max(int[] arr) {
    int n = arr.length;
    int max = Math.abs(arr[n - 1] - arr[0]);
    for (int i = 0; i < n - 1; i++) {
      max = Math.max(max, Math.abs(arr[i] - arr[i + 1]));
    }
    return max;
  }

  int perm(int[] arr, int i) {
    int min = max(arr);
    for (int k = i; k < arr.length; k++) {
      swap(arr, i, k);
      min = Math.min(perm(arr, i + 1), min);
      swap(arr, k, i); // back track
    }
    return min;
  }

  int minOverallAwkwardness(int[] arr) {
    // Write your code here
    return perm(arr, 0);
  }

  public static void main(String[] args) {
    SeatingArrangements sa = new SeatingArrangements();
    System.out.println(sa.minOverallAwkwardness(new int[] {5, 10, 6, 8}));
    System.out.println(sa.minOverallAwkwardness(new int[] {1, 2, 5, 3,7}));
  }
}
