package sort;

public class MinimizingPermutation {
  void reverse(int[] arr, int s, int e) {
    while (s < e) {
      // one line swap
      arr[s] = arr[s] ^ arr[e] ^ (arr[e] = arr[s]);
      s++;
      e--;
    }

    // System.out.println(Arrays.toString(arr));
  }

  int minOperations(int[] arr) {
    // Write your code here
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (i != arr[i] - 1) {
        reverse(arr, i, arr[i] - 1);
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    MinimizingPermutation mp = new MinimizingPermutation();
    System.out.println(mp.minOperations(new int[]{3,1,2}));
  }
}
