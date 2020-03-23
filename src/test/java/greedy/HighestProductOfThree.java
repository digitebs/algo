package greedy;

public class HighestProductOfThree {
  public static int highestProductOf3(int[] arr) {

    if (arr.length <= 2) throw new IllegalArgumentException("less than 3");
    // calculate the highest product of three numbers
    int max = Math.max(arr[0], arr[1]);
    int min = Math.min(arr[0], arr[1]);
    int maxp2 = arr[0] * arr[1];
    int minp2 = arr[0] * arr[1];
    int maxp3 = arr[0] * arr[1] * arr[2];
    for (int i = 2; i < arr.length; i++) {
      int curr = arr[i];
      maxp3 = Math.max(Math.max(maxp3, maxp2 * curr), minp2 * curr);
      maxp2 = Math.max(Math.max(maxp2, max * curr), min * curr);
      minp2 = Math.min(Math.min(minp2, max * curr), min * curr);
      max = Math.max(max, curr);
      min = Math.min(min, curr);
    }
    return maxp3;
  }

  public static void main(String[] args) {
      highestProductOf3(new int[]{-10, 1, 3, 2, -10});
      highestProductOf3(new int[]{-5, -1, -3, -2});
      highestProductOf3(new int[]{-5, 4, 8, 2,3 });
      highestProductOf3(new int[]{6, 1, 3, 5, 7, 8, 2});
  }
}
