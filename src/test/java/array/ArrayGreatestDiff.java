package array;

public class ArrayGreatestDiff {

  private static int diff(int[] arr) {
    int min = arr[0]; // you can start with the 1st element
    int max = arr[0]; // you can start with the 1st element

    for (int a : arr) {
      min = Math.min(a, min);
      max = Math.max(a, max);
    }
    return max - min;
  }

  public static void main(String[] args) {
    System.out.println(diff(new int[] {5, 8, 6, 1}));
  }
}
